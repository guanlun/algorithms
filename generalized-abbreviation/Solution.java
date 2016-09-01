public class Solution {
    public List<String> generateAbbreviations(String word) {
        ArrayList<String> results = new ArrayList<String>();
        
        recur(results, word, "", 0, false);
        
        return results;
    }
    
    private void recur(ArrayList<String> results, String word, String curr, int pos, boolean lastIsNum) {
        int len = word.length();
        
        if (pos == len) {
            results.add(curr);
            return;
        }
        
        recur(results, word, curr + "" + word.charAt(pos), pos + 1, false);
        
        if (!lastIsNum) {
            for (int i = pos + 1; i <= len; i++) {
                recur(results, word, curr + "" + (i - pos), i, true);
            }
        }
    }
}
