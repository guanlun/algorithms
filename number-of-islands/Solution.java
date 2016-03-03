public class Solution {
    private void dfs(char[][]grid, int i, int j, int rows, int cols) {
        if ((i == rows) || (j == cols) || (i == -1) || (j == -1)) {
            return;
        }
        
        if (grid[i][j] == '1') {
            grid[i][j] = '2';
            dfs(grid, i + 1, j, rows, cols);
            dfs(grid, i, j + 1, rows, cols);
            dfs(grid, i - 1, j, rows, cols);
            dfs(grid, i, j - 1, rows, cols);
        }
    }

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        
        if (rows == 0) {
            return 0;
        }
        
        int cols = grid[0].length;
        
        if (cols == 0) {
            return 0;
        }
        
        int numIslands = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, rows, cols);
                    numIslands++;
                }
            }
        }
        
        return numIslands;
    }
}
