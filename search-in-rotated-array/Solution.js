/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    var left = 0,
        right = nums.length - 1;
    
    while (left <= right) {
        var mid = (left + right) >> 1;
    
        var leftVal = nums[left],
            rightVal = nums[right],
            midVal = nums[mid];

        if (midVal === target) {
            return mid;
        }
        
        if (leftVal <= midVal && midVal <= rightVal) {
            if (target < midVal) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        } else if (leftVal >= midVal && midVal <= rightVal) {
            if (target >= leftVal || target <= midVal) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        } else if (leftVal <= midVal && midVal >= rightVal) {
            if (target >= leftVal && target <= midVal) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }
    
    return -1;
}
