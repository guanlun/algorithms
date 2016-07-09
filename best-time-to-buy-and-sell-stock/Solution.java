public class Solution {
    public int maxProfit(int[] prices) {
        int maxDiff = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            
            int currDiff = price - minPrice;
            
            if (currDiff > maxDiff) {
                maxDiff = currDiff;
            }
        }
        
        return maxDiff;
    }
}
