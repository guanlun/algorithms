public class Solution {
    public void reverseWords(char[] s) {
        int len = s.length;
        
        // Reverse all chars first
        this.reverse(s, 0, len - 1);
        
        int wordStart = 0;
        
        // Reverse each word
        for (int i = 0; i < len; i++) {
            if (s[i] == ' ') {
                this.reverse(s, wordStart, i - 1);
                
                wordStart = i + 1;
            }
        }
        
        // Reverse the last word
        this.reverse(s, wordStart, len - 1);
    }
    
    private void reverse(char[] s, int from, int to) {
        int left = from, right = to;
        
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}
