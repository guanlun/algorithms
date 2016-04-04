public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        
        int num = x;
        int numDigits = 0;
        
        while (num != 0) {
            num /= 10;
            numDigits++;
        }
        
        while (x != 0) {
            if (numDigits <= 1) {
                break;
            }
            
            int last = x % 10;
            int power = (int)Math.pow(10, numDigits - 1);
            int first = x / power;
            
            if (first != last) {
                return false;
            }
            
            numDigits -= 2;
            
            x = (x - first * power) / 10;
        }
        return true;
    }
}
