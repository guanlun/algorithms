/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var nextPermutation = function(nums) {
    var reversePoint = findReversePoint(nums);
    
    reverseFrom(nums, reversePoint);
};

var findReversePoint = function(nums) {
    var last = nums.length - 1;
    
    // Find the last element that's smaller than it's next element.
    for (var lastIncreasingIndex = last; lastIncreasingIndex > 0; lastIncreasingIndex--) {
        if (nums[lastIncreasingIndex - 1] < nums[lastIncreasingIndex]) {
            break;
        }
    }
    
    if (lastIncreasingIndex === 0) {
        return 0;
    }
    
    // Now find the min element that's larger than the last increasing element.
    var pivot = nums[lastIncreasingIndex - 1];
    var minLargerIdx = lastIncreasingIndex;
    var minLargerItem = nums[lastIncreasingIndex];
    
    for (var i = lastIncreasingIndex; i < nums.length; i++) {
        var item = nums[i];
        if ((item > pivot) && (item <= minLargerItem)) { // Use <= !!!
            minLargerItem = item;
            minLargerIdx = i;
        }
    }
    
    swap(nums, lastIncreasingIndex - 1, minLargerIdx);
    
    return lastIncreasingIndex;
};

var reverseFrom = function(nums, index) {
    var left = index;
    var right = nums.length - 1;
    
    while (left < right) {
        swap(nums, left, right);
        left++;
        right--;
    }
};

var swap = function(nums, idx1, idx2) {
    var temp = nums[idx1];
    nums[idx1] = nums[idx2];
    nums[idx2] = temp;
};
