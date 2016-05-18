var sortColors = function(nums) {
    if (nums.length === 0) {
        return;
    }
    
    var left = 0,
        right = nums.length - 1,
        i = 0;
    
    while (i <= right) {
        if (nums[i] === 0) {
            var temp = nums[i];
            nums[i] = nums[left];
            nums[left] = temp;
            
            left++;
            i++;
        } else if (nums[i] === 2) {
            var temp = nums[i];
            nums[i] = nums[right];
            nums[right] = temp;
            
            right--;
        } else {
            i++;
        }
    }
};
