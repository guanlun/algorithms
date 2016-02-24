public class Solution {
    public int maxProfit(int[] prices) {
        boolean bought = false;
        int profit = 0;
        
        for (int i = 0; i < prices.length - 1; i++) {
            int curr = prices[i];
            int next = prices[i + 1];
            
            if (bought) {
                if (next > curr) {
                    profit += next - curr;
                } else {
                    bought = false;
                }
            } else {
                if (next > curr) {
                    bought = true;
                    profit += next - curr;
                }
            }
        }
        
        return profit;
    }
}
