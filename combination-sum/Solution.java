public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
        
        ArrayList<Integer> currResult = new ArrayList<Integer>();
        
        Arrays.sort(candidates);
        
        recur(results, currResult, candidates, target, 0);
        
        return results;
    }
    
    public void recur(ArrayList<List<Integer>> results, ArrayList<Integer> currResult, int[] candidates, int rem, int startPos) {
        if (rem < 0) {
            return;
        }
        
        if (rem == 0) {
            results.add(new ArrayList<Integer>(currResult));
            return;
        }
        
        for (int i = startPos; i < candidates.length; i++) {
            int num = candidates[i];
            
            currResult.add(num);
            
            recur(results, currResult, candidates, rem - num, i);
            
            currResult.remove(currResult.size() - 1);
        }
    }
}
