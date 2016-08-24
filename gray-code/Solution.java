public class Solution {
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        result.add(0);
        
        int orOperand = 1;
        
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> tempResult = new ArrayList<Integer>();
            
            for (int numIdx = 0; numIdx < result.size(); numIdx++) {
                tempResult.add(result.get(numIdx));
            }
            
            for (int numIdx = result.size() - 1; numIdx >= 0; numIdx--) {
                tempResult.add(result.get(numIdx) | orOperand);
            }
            
            result = tempResult;
            
            orOperand <<= 1;
        }
        
        return result;
    }
}