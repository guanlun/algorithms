var findMinRecur = function(nums, left, right) {
    if (left === right) {
        return nums[left];
    } else if (left === right - 1) {
        return Math.min(nums[left], nums[right]);
    }
    
    var mid = Math.floor((left + right) / 2);
    if ((nums[mid] > nums[left]) && (nums[mid] > nums[right])) {
        // larger than left and right
        return findMinRecur(nums, mid + 1, right);
    } else if ((nums[mid] < nums[left]) && (nums[mid] < nums[right])) {
        // smaller than left and right
        return findMinRecur(nums, left + 1, mid);
    } else {
        // in the middle
        return findMinRecur(nums, left, mid - 1);
    }
};

var findMin = function(nums) {
    return findMinRecur(nums, 0, nums.length - 1);
};
