import java.util.*;

class Solution {
    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);
      
        while (sc.hasNext()) {
            String input = sc.next();
        
            System.out.println(solveCase(input));
        }
    }
    
    private static boolean solveCase(String str) {
        int len = str.length();
        
        Stack<Character> pStack = new Stack<Character>();
        
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            
            if (isOpenParenthesis(c)) {
                pStack.push(c);
            } else {
                if (pStack.empty()) {
                    return false;
                }
                
                char lastC = pStack.peek();
                
                if (!parenthesesMatch(lastC, c)) {
                    return false;
                }
                
                pStack.pop();
            }
        }
        
        return pStack.empty();
    }
    
    private static boolean isOpenParenthesis(char p) {
        return (p == '{') || (p == '[') || (p == '(');
    }
    
    private static boolean parenthesesMatch(char p1, char p2) {
        return (p1 == '{' && p2 == '}')
            || (p1 == '[' && p2 == ']')
            || (p1 == '(' && p2 == ')');
    }
}
