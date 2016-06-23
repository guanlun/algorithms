var removeDuplicates = function(nums) {
    var len = nums.length;
    var i = 1;
    var offset = 0;
    var last = nums[0];
    
    while (i + offset < len) {
        while (nums[i + offset] === last) {
            offset++;
            if (i + offset >= len) {
                return i;
            }
        }
        
        nums[i] = nums[i + offset];
        last = nums[i];
        i++;
    }
    
    return i;
};
