var rob = function(nums) {
    var numsLength = nums.length;
    if (numsLength === 0) {
        return 0;
    }
    
    var lookup = [
        nums[0],
        Math.max(nums[0], nums[1]),
        Math.max(nums[0] + nums[2], nums[1])
    ];

    for (var i = 3; i < numsLength; i++) {
        var prev1 = lookup[i - 1];
        var prev2 = lookup[i - 2];
        var prev3 = lookup[i - 3];
        
        lookup[i] = Math.max(prev1, prev2 + nums[i], prev3 + nums[i]);
    }
    
    return lookup[numsLength - 1];
};
