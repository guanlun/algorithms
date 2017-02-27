public class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> digits = new ArrayList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        for (int i = 1; i <= n; i++) {
            digits.add(i);
        }
        
        helper(result, digits, k - 1);
        
        String s = "";
        for (int item : result) {
            s += item;
        }
        
        return s;
    }
    
    private void helper(ArrayList<Integer> result, ArrayList<Integer> digits, int k) {
        if (k == 0) {
            for (int item : digits) {
                result.add(item);
            }
        } else {
            int n = digits.size() - 1;
            int f = factorial(n);
            int idx = k / f;
            
            result.add(digits.remove(idx));
            
            helper(result, digits, k % f);
        }
    }
    
    private int factorial(int n) {
        int f = 1;
        
        for (int i = 2; i <= n; i++) {
            f *= i;
        }
        
        return f;
    }
}
