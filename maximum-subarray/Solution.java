public class Solution {
    public int maxSubArray(int[] nums) {
        int i = 0;
        int len = nums.length;
        int currSum = 0;
        int maxSum = 0;
        
        int positiveSum = 0;
        int negativeSum = 0;
        
        int largestNegativeNum = -Integer.MAX_VALUE;
        boolean allNegative = true;

        for (i = 0; i < len; i++) {
            int curr = nums[i];
            if (curr >= 0) {
                allNegative = false;
                break;
            } else {
                if (curr > largestNegativeNum) {
                    largestNegativeNum = curr;
                }
            }
        }
        
        if (allNegative) {
            return largestNegativeNum;
        }
        
        while (i < len) {
            int curr = nums[i];
            
            if (curr >= 0) {
                positiveSum = 0;

                while ((i < len) && (nums[i] >= 0)) {
                    positiveSum += nums[i];
                    i++;
                }
                
                currSum += positiveSum;
                
                if (currSum > maxSum) {
                    maxSum = currSum;
                }
            } else {
                negativeSum = 0;
                
                while ((i < len) && (nums[i] <= 0)) {
                    negativeSum -= nums[i];
                    i++;
                }
                
                if (negativeSum > currSum) {
                    currSum = 0;
                } else {
                    currSum -= negativeSum;
                }
            }
        }
        
        return maxSum;
    }
}
