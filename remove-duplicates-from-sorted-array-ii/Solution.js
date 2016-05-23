var removeDuplicates = function(nums) {
    var count = 1;
    var length = nums.length;
    var offset = 0;
    var index = 1;
        
    while (index + offset < length) {
        nums[index] = nums[index + offset];
        
        var num = nums[index];
        
        if (nums[index] === nums[index - 1]) {
            count++;
        } else {
            count = 1;
        }
        
        if (count > 2) {
            offset++;
        } else {
            index++;
        }
    }
    
    return length - offset;
};
