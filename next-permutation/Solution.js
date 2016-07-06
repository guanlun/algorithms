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
    
    // Find the first element that's smaller than it's next element.
    for (var firstIncreasingIdx = last; firstIncreasingIdx > 0; firstIncreasingIdx--) {
        if (nums[firstIncreasingIdx - 1] < nums[firstIncreasingIdx]) {
            break;
        }
    }
    
    if (firstIncreasingIdx === 0) {
        return 0;
    }
    
    // Now find the min element that's larger than the first increasing element.
    var pivot = nums[firstIncreasingIdx - 1];
    var minLargerIdx = firstIncreasingIdx;
    var minLargerItem = nums[firstIncreasingIdx];
    
    for (var i = firstIncreasingIdx; i < nums.length; i++) {
        var item = nums[i];
        if ((item > pivot) && (item <= minLargerItem)) { // Use <= !!!
            minLargerItem = item;
            minLargerIdx = i;
        }
    }
    
    swap(nums, firstIncreasingIdx - 1, minLargerIdx);
    
    return firstIncreasingIdx;
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
