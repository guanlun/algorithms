/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsetsWithDup = function(nums) {
    qsort(nums, 0, nums.length - 1);

    var results = [ [] ];
    var lastSize = 0;

    for (var i = 0; i < nums.length; i++) {
        var resultLen = results.length;
        
        var beginAt = 0;
        if ((i !== 0) && (nums[i] === nums[i - 1])) {
            beginAt = lastSize;
        }
        
        for (var resultIdx = beginAt; resultIdx < resultLen; resultIdx++) {
            var prevResult = results[resultIdx];
            var newResult = prevResult.slice(0);
            newResult.push(nums[i]);

            results.push(newResult);
        }
        
        lastSize = resultLen;
    }
    
    return results;
};

var qsort = function(nums, left, right) {
    if (left >= right) {
        return;
    }
    
    var middle = (left + right) >> 1;
    var pivot = nums[middle];
    
    var i = left, j = right;
    
    while (i < j) {
        while (nums[i] < pivot) {
            i++;
        }
        
        while (nums[j] > pivot) {
            j--;
        }
        
        if (i <= j) {
            var temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
    
    qsort(nums, left, j);
    qsort(nums, i, right);
};
