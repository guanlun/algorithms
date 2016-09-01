public class Solution {
    class RegexSeg {
        char c;
        boolean star;
        
        RegexSeg(char c, boolean star) {
            this.c = c;
            this.star = star;
        }
    }
    
    public boolean isMatch(String s, String p) {
        ArrayList<RegexSeg> regex = new ArrayList<RegexSeg>();
        
        char lastChar = 0;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            
            if (c == '*') {
                regex.add(new RegexSeg(lastChar, true));
            } else {
                if (lastChar != '*' && lastChar != 0) {
                    regex.add(new RegexSeg(lastChar, false));
                }
            }
            
            lastChar = c;
        }
        
        if (lastChar != '*' && lastChar != 0) {
            regex.add(new RegexSeg(lastChar, false));
        }
        
        int strLen = s.length();
        int regexLen = regex.size();
        
        boolean[][] result = new boolean[strLen + 1][regexLen + 1];
        result[0][0] = true;
        
        boolean star = true;
        for (int i = 1; i <= regexLen; i++) {
            if (!star) {
                result[0][i] = false;
            } else {
                RegexSeg r = regex.get(i - 1);
                
                if (!r.star) {
                    result[0][i] = false;
                    star = false;
                } else {
                    result[0][i] = true;
                }
            }
        }
        
        for (int i = 1; i <= strLen; i++) {
            result[i][0] = false;
        }
        
        for (int i = 1; i <= strLen; i++) {
            for (int j = 1; j <= regexLen; j++) {
                RegexSeg r = regex.get(j - 1);
                char c = s.charAt(i - 1);
                
                if (r.star) {
                    if (r.c == '.' || r.c == c) {
                        result[i][j] = result[i - 1][j - 1] || result[i - 1][j] || result[i][j - 1];
                    } else {
                        result[i][j] = result[i][j - 1];
                    }
                } else {
                    if (r.c == '.' || r.c == c) {
                        result[i][j] = result[i - 1][j - 1];
                    } else {
                        result[i][j] = false;
                    }
                }
            }
        }
        
        return result[strLen][regexLen];
    }
}
