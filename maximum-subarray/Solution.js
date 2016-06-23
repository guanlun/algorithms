var maxSubArray = function(nums) {
    return maxSubInRange(nums, 0, nums.length - 1);
};

var maxSubInRange = function(nums, left, right) {
    if (left == right) {
        return nums[left];
    }
    
    var middle = (left + right) >> 1;
    
    var leftMax = 0,
        rightMax = 0;
        
    var leftSum = 0,
        rightSum = 0;
        
    for (var i = middle - 1; i >= left; i--) {
        leftSum += nums[i];
        
        if (leftSum > leftMax) {
            leftMax = leftSum;
        }
    }
    
    for (var j = middle + 1; j <= right; j++) {
        rightSum += nums[j];
        
        if (rightSum > rightMax) {
            rightMax = rightSum;
        }
    }
    
    var maxWithMiddle = leftMax + nums[middle] + rightMax;
    
    var maxFromLeftSub = - Number.MAX_VALUE,
        maxFromRightSub = - Number.MAX_VALUE;
        
    if (left <= middle - 1) {
        maxFromLeftSub = maxSubInRange(nums, left, middle - 1);
    }
    
    if (middle + 1 <= right) {
        maxFromRightSub = maxSubInRange(nums, middle + 1, right);
    }
    
    return Math.max(maxWithMiddle, maxFromLeftSub, maxFromRightSub);
};
