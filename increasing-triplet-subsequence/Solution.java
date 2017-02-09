public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        
        boolean hasPair = false;
        int min = Integer.MAX_VALUE;
        
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        
        for (int n : nums) {
            if (n <= min) {
                min = n;
                continue;
            }
            
            if (!hasPair) {
                first = min;
                second = n;
                
                hasPair = true;
            } else {
                if (n > second) {
                    return true;
                } else if (n < second) {
                    first = min;
                    second = n;
                }
            }
        }
        
        return false;
    }
}
