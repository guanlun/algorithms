public class Solution {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return result;
        }
        
        result.add(new ArrayList<Integer>());
        result.get(0).add(1);
        
        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> currRow = new ArrayList<Integer>();
            List<Integer> lastRow = result.get(i - 1);
            
            currRow.add(lastRow.get(0));
            
            for (int j = 1; j < i; j++) {
                currRow.add(lastRow.get(j - 1) + lastRow.get(j));
            }
            
            currRow.add(lastRow.get(i - 1));
            
            result.add(currRow);
        }
        
        return result;
    }
}
