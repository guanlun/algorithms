public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        
        int beginIdx = 0, endIdx = 0;
        int currSum = 0;

        boolean reached = false;
        
        while (endIdx < nums.length) {
            while ((currSum < s) && (endIdx < nums.length)) {
                currSum += nums[endIdx];
                endIdx++;
            }
            
            if (currSum >= s) {
                reached = true;
            }
            
            while (currSum >= s) {
                currSum -= nums[beginIdx];
                beginIdx++;
            }
            
            int len = endIdx - beginIdx + 1;
            if (len < minLen) {
                minLen = len;
            }
        }
        
        if (reached) {
            return minLen;
        } else {
            return 0;
        }
    }
}
