public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        
        if (sLen == tLen) {
            boolean diffBefore = false;
            for (int i = 0; i < sLen; i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    if (diffBefore) {
                        return false;
                    }
                    
                    diffBefore = true;
                }
            }
            
            return diffBefore;
        } else if (Math.abs(sLen - tLen) > 1) {
            return false;
        }
        
        String shorter, longer;
        if (sLen < tLen) {
            shorter = s;
            longer = t;
        } else {
            shorter = t;
            longer = s;
        }
        
        int len = shorter.length();
        
        for (int i = 0; i < len; i++) {
            if (shorter.charAt(i) != longer.charAt(i)) {
                return shorter.substring(i, len).equals(longer.substring(i + 1, len + 1));
            }
        }
        
        return true;
        
        // generic solution:
        /*
        int sLen = s.length();
        int tLen = t.length();
        
        int[][] lookup = new int[tLen + 1][sLen + 1];
        
        for (int row = 0; row < tLen + 1; row++) {
            for (int col = 0; col < sLen + 1; col++) {
                if (row == 0) {
                    lookup[row][col] = col;
                } else if (col == 0) {
                    lookup[row][col] = row;
                } else {
                    char sc = s.charAt(col - 1);
                    char tc = t.charAt(row - 1);
                    
                    int topRes = lookup[row - 1][col] + 1;
                    int leftRes = lookup[row][col - 1] + 1;
                    int topLeftRes = lookup[row - 1][col - 1];
                    
                    if (sc != tc) {
                        topLeftRes++;
                    }
                    
                    lookup[row][col] = Math.min(Math.min(topRes, leftRes), topLeftRes);
                }
            }
        }
        
        return lookup[tLen][sLen] == 1;
        */
    }
}
