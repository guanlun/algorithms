public class Solution {
    public int missingNumber(int[] nums) {
        int result = 0;
        int i;
        
        for (i = 0; i < nums.length; i++) {
            result ^= i ^ nums[i];
        }
        
        return result ^ i;
    }
}
