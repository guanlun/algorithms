public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int[] results = new int[amount + 1];
        results[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            
            for (int coin : coins) {
                int prevAmount = i - coin;
                if (prevAmount < 0) {
                    continue;
                }
                
                int prevResult = results[prevAmount];
                if (prevResult == -1) {
                    continue;
                }
                
                int currNum = 1 + results[prevAmount];
                if (currNum < min) {
                    min = currNum;
                }
            }

            if (min == Integer.MAX_VALUE) {
                results[i] = -1;
            } else {
                results[i] = min;
            }
        }
        
        return results[amount];
    }
}
