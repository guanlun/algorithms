public class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        
        if (len == 0) {
            return 0;
        }
        
        int left = 0;
        int right = len - 1;
        
        while (left <= right) {
            if (nums[left] == val) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                
                right--;
            } else {
                left++;
            }
        }
        
        return right + 1;
    }
}
