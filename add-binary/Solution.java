public class Solution {
    public String addBinary(String a, String b) {
        boolean carry = false;
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int digit;
        String result = "";
        
        while (true) {
            digit = 0;

            if ((indexA == -1) && (indexB == -1)) {
                if (carry) {
                    return '1' + result;
                } else {
                    return result;
                }
            }
            
            if (indexA != -1) {
                if (a.charAt(indexA) == '1') {
                    digit++;
                }
                
                indexA--;
            }
            
            if (indexB != -1) {
                if (b.charAt(indexB) == '1') {
                    digit++;
                }
                
                indexB--;
            }
            
            if (carry) {
                digit++;
            }
            
            carry = (digit >= 2);
            result = (digit % 2) + result;
        }
    }
}
