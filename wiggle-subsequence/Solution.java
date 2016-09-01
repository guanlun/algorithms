public class Solution {
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        
        if (len == 0) {
            return 0;
        }
        
        int[][] res = new int[len][2];
        
        res[0][0] = 1;
        res[0][1] = 1;
        
        for (int i = 1; i < len; i++) {
            int maxInc = 0;
            int maxDec = 0;
                
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    int incLen = res[j][1];
                    if (incLen > maxInc) {
                        maxInc = incLen;
                    }
                } else if (nums[i] < nums[j]) {
                    int decLen = res[j][0];
                    if (decLen > maxDec) {
                        maxDec = decLen;
                    }
                }
            }
            
            res[i][0] = maxInc + 1;
            res[i][1] = maxDec + 1;
        }
        
        return Math.max(res[len - 1][0], res[len - 1][1]);
    }
}
