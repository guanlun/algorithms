public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        
        int[] range = { -1, -1 };
        
        if (len == 0) {
            return range;
        }

        int left = 0;
        int right = len - 1;
        int mid;
        
        while (left != right) {
            mid = left + (right - left) / 2;
            
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        if (nums[left] == target) {
            range[0] = left;
        } else if (left < len - 1 && nums[left + 1] == target) {
            range[0] = left + 1;
        }
        
        right = len - 1;
        
        while (left != right) {
            mid = left + (right - left) / 2;
            
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        if (nums[left] == target) {
            range[1] = left;
        } else if (left > 0 && nums[left - 1] == target) {
            range[1] = left - 1;
        }
        
        return range;
    }
}
