public class Solution {
    public int uniquePaths(int m, int n) {
        if ((m == 0) || (n == 0)) {
            return 1;
        }

        ArrayList<ArrayList<Integer>> mtx = new ArrayList<ArrayList<Integer>>(m);
        
        for (int rowIdx = 0; rowIdx < m; rowIdx++) {
            ArrayList<Integer> row = new ArrayList<Integer>(n);
            for (int colIdx = 0; colIdx < n; colIdx++) {
                if (rowIdx == 0) {
                    // First row
                    row.add(1);
                } else {
                    // Starting from second row
                    if (colIdx == 0) {
                        // First column
                        row.add(1);
                    } else {
                        // Starting from second column
                        int upperCellNumOfWays = mtx.get(rowIdx - 1).get(colIdx);
                        int leftCellNumOfWays = row.get(colIdx - 1);
                        row.add(upperCellNumOfWays + leftCellNumOfWays);
                    }
                }
            }
            
            mtx.add(row);
        }
        
        return mtx.get(m - 1).get(n - 1);
    }
}
