public class Solution {
    public int maxSubArray(int[] nums) {
        int localMax = -Integer.MAX_VALUE;
        int max = -Integer.MAX_VALUE;
        
        for (int n : nums) {
            if (localMax < 0) {
                localMax = n;
            } else {
                localMax += n;
            }
            
            if (localMax > max) {
                max = localMax;
            }
        }
        
        return max;
    }
}
