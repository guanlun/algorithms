public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int numRow = obstacleGrid.length;
        int numCol = obstacleGrid[0].length;
        int[][] results = new int[numRow][numCol];
        
        for (int row = 0; row < numRow; row++) {
            for (int col = 0; col < numCol; col++) {
                results[row][col] = 0;
            }
        }
        
        for (int row = 0; row < numRow; row++) {
            if (obstacleGrid[row][0] == 1) {
                break;
            }
            results[row][0] = 1;
        }
        
        for (int col = 0; col < numCol; col++) {
            if (obstacleGrid[0][col] == 1) {
                break;
            }
            results[0][col] = 1;
        }
        
        for (int row = 1; row < numRow; row++) {
            for (int col = 1; col < numCol; col++) {
                if (obstacleGrid[row][col] == 1) {
                    results[row][col] = 0;
                } else {
                    results[row][col] = results[row][col - 1] + results[row - 1][col];
                }
            }
        }
        
        return results[numRow - 1][numCol - 1];
    }
}
