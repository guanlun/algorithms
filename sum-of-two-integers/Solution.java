public class Solution {
    public int getSum(int a, int b) {
        boolean carry = false;
        int multiplier = 1;
        int result = 0;
        
        for (int i = 0; i < 32; i++) {
            int da = a & multiplier;
            int db = b & multiplier;
            
            if (da != db) {
                // 1 and 0
                if (carry) {
                    // do nothing
                } else {
                    result |= multiplier;
                }
            } else if (da == 0 && db == 0) {
                // both 0
                if (carry) {
                    result |= multiplier;
                }
                carry = false;
            } else {
                // both 1
                if (carry) {
                    result |= multiplier;
                }
                
                carry = true;
            }
            
            multiplier <<= 1;
        }
        
        return result;
    }
}
