public class Solution {
    public int minCost(int[][] costs) {
        int num = costs.length;
        
        if (num == 0) {
            return 0;
        }
        
        int[][] totalCosts = new int[num][3];
        
        totalCosts[0][0] = costs[0][0];
        totalCosts[0][1] = costs[0][1];
        totalCosts[0][2] = costs[0][2];
        
        for (int i = 1; i < num; i++) {
            totalCosts[i][0] = Math.min(totalCosts[i - 1][1], totalCosts[i - 1][2]) + costs[i][0];
            totalCosts[i][1] = Math.min(totalCosts[i - 1][0], totalCosts[i - 1][2]) + costs[i][1];
            totalCosts[i][2] = Math.min(totalCosts[i - 1][0], totalCosts[i - 1][1]) + costs[i][2];
        }
        
        return Math.min(totalCosts[num - 1][0], Math.min(totalCosts[num - 1][1], totalCosts[num - 1][2]));
    }
}
