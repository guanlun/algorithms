public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int strLen = s.length();
        
        boolean[][] lookup = new boolean[strLen][strLen];
        
        for (int len = 1; len <= strLen; len++) {
            for (int startPos = 0; startPos + len <= strLen; startPos++) {
                String substr = s.substring(startPos, startPos + len);
                
                if (wordDict.contains(substr)) {
                    lookup[startPos][startPos + len - 1] = true;
                    continue;
                }
                
                for (int breakAt = 1; breakAt < len; breakAt++) {
                    if (lookup[startPos][startPos + breakAt - 1] && lookup[startPos + breakAt][startPos + len - 1]) {
                        lookup[startPos][startPos + len - 1] = true;
                        break;
                    }
                }
            }
        }
        
        return lookup[0][strLen - 1];
    }
}
