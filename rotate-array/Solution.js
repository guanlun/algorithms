var rotate = function(nums, k) {
    if (nums.length === 0) {
        return;
    }
    
    k %= nums.length;
    
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
};

var reverse = function(nums, begin, end) {
    while (begin < end) {
        var temp = nums[begin];
        nums[begin] = nums[end];
        nums[end] = temp;
        
        begin++;
        end--;
    }
};
