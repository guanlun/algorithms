public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        
        int[][] lookup = new int[len1 + 1][len2 + 1];
        
        for (int i = 0; i <= len1; i++) {
            lookup[i][0] = i;
        }
        
        for (int j = 0; j <= len2; j++) {
            lookup[0][j] = j;
        }
        
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int topResult = lookup[i - 1][j] + 1;
                int leftResult = lookup[i][j - 1] + 1;
                int topLeftResult = lookup[i - 1][j - 1];
                
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    topLeftResult++;
                }
                
                lookup[i][j] = Math.min(Math.min(topResult, leftResult), topLeftResult);
            }
        }
        
        return lookup[len1][len2];
    }
}
