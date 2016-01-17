public class Solution {
    public boolean isValid(String s) {
        ArrayList<Character> stack = new ArrayList<Character>();
        
        for (int i = 0; i < s.length(); i++) {
            char paren = s.charAt(i);
            
            if ((paren == '(') || (paren == '[') || (paren == '{')) {
                stack.add(paren);
            } else if ((paren == ')') || (paren == ']') || (paren == '}')) {
                if (stack.size() == 0) {
                    return false;
                }
                
                char prev = stack.remove(stack.size() - 1);
                if ((paren == ')') && (prev != '(')) {
                    return false;
                } else if ((paren == ')') && (prev != '(')) {
                    return false;
                } else if ((paren == ')') && (prev != '(')) {
                    return false;
                }
            }
            
        }
        return (stack.size() == 0);
    }
}
