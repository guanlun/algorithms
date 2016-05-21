public class Solution {
    public String convertToTitle(int n) {
        String result = "";
        
        while (n != 0) {
            n -= 1;
            int remainder = n % 26;
            char newChar = ((char)(remainder + 65));
            
            result = newChar + result;
            
            n /= 26;
        }
        
        return result;
    }
}
