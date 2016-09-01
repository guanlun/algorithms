public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        ArrayList<Integer> lastRowResult = new ArrayList<Integer>();
        lastRowResult.add(triangle.get(0).get(0));
        
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);
            ArrayList<Integer> rowResult = new ArrayList<Integer>();
            
            for (int j = 0; j < row.size(); j++) {
                int leftResult = Integer.MAX_VALUE;
                int rightResult = Integer.MAX_VALUE;
                
                if (j != 0) {
                    leftResult = lastRowResult.get(j - 1);
                }
                
                if (j != row.size() - 1) {
                    rightResult = lastRowResult.get(j);
                }
                
                rowResult.add(Math.min(leftResult, rightResult) + row.get(j));
            }
            
            lastRowResult = rowResult;
        }
        
        int minResult = Integer.MAX_VALUE;
        
        for (int r : lastRowResult) {
            if (r < minResult) {
                minResult = r;
            }
        }
        
        return minResult;
    }
}
