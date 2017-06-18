public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        
        List<String> currResult = new ArrayList<>();
        
        helper(results, currResult, s, 0);
        
        return results;
    }
    
    private void helper(List<List<String>> results, List<String> currResult, String s, int startPos) {
        int len = s.length();
        
        if (startPos == len) {
            results.add(new ArrayList<String>(currResult));
        }
        
        for (int i = startPos; i < len; i++) {
            if (isPalindrome(s, startPos, i)) {
                currResult.add(s.substring(startPos, i + 1));
                helper(results, currResult, s, i + 1);
                currResult.remove(currResult.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int from, int to) {
        int left = from, right = to;
        
        while (left <= right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }
        
        return (left >= right);
    }
}
