public class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        
        if (len == 0) {
            return 0;
        } else if (len == 1) {
            return nums[0];
        }
        
        int sum = 0;
        
        int[] sums = new int[len];
        
        sums[0] = nums[0];
        sums[1] = Math.max(nums[0], nums[1]);
        
        if (len == 2) {
            return sums[1];
        }
        
        for (int i = 2; i < len - 1; i++) {
            sums[i] = Math.max(sums[i - 1], sums[i - 2] + nums[i]);
        }
        
        sum = sums[len - 2];
        
        sums = new int[len];
        sums[1] = nums[1];
        sums[2] = Math.max(nums[1], nums[2]);
        
        for (int i = 3; i < len; i++) {
            sums[i] = Math.max(sums[i - 1], sums[i - 2] + nums[i]);
        }
        
        return Math.max(sums[len - 1], sum);
    }
}
