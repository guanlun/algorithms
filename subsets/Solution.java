public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
        results.add(new ArrayList<Integer>());
        
        for (int n : nums) {
            int len = results.size();
            
            for (int i = 0; i < len; i++) {
                List<Integer> result = results.get(i);
                
                ArrayList<Integer> copy = new ArrayList<Integer>(result);
                copy.add(n);
                
                results.add(copy);
            }
        }
        
        return results;
    }
}
