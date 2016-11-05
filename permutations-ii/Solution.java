public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;

        boolean[] used = new boolean[len];

        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();

        ArrayList<Integer> currResult = new ArrayList<Integer>();

        helper(result, currResult, nums, used);

        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> currResult, int[] nums, boolean[] used) {
        if (currResult.size() == nums.length) {
            result.add(new ArrayList<Integer>(currResult));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (used[i] || ((i > 0) && (nums[i - 1] == num) && used[i - 1])) {
                continue;
            }

            currResult.add(num);
            used[i] = true;
            helper(result, currResult, nums, used);
            used[i] = false;
            currResult.remove(currResult.size() - 1);
        }
    }
}
