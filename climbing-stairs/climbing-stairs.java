public class Solution {
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        
        ArrayList<Integer> results = new ArrayList<Integer>();

        results.add(1);
        
        int count = 0;
        
        for (int i = 1; i <= n; i++) {
            count = 0;
            if (i - 2 >= 0) {
                count += results.get(i - 2);
            }
            
            count += results.get(i - 1);
            
            results.add(count);
        }
        
        return count;
    }
}
