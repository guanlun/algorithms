class Solution {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
        
        ArrayList<Integer> currResult = new ArrayList<Integer>();
        
        boolean[] used = new boolean[nums.length];
        
        permuteRecur(results, currResult, nums, used);
        
        return results;
    }
    
    public void permuteRecur(List<List<Integer>> results, List<Integer> currResult, int[] nums, boolean[] used) {
        if (nums.length == currResult.size()) {
            results.add(new ArrayList<Integer>(currResult));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            
            currResult.add(nums[i]);
            used[i] = true;
            permuteRecur(results, currResult, nums, used);
            currResult.remove(currResult.size() - 1);
            used[i] = false;
        }
    }
}
