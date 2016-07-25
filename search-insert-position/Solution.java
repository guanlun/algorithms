public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return nums[0] >= target ? 0 : 1;
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left != right - 1) {
            int mid = (left + right) >> 1;
            
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        if (nums[left] >= target) {
            return left;
        }
        
        if (nums[right] < target) {
            return right + 1;
        }
        
        return right;
    }
}
