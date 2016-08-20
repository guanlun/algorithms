public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = { 0, 0 };
        HashMap<Integer, Integer> lookup = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            
            Integer index = lookup.get(rem);
            
            if (index != null) {
                result[0] = index;
                result[1] = i;
                
                break;
            }
            
            lookup.put(nums[i], i);
        }
        
        return result;
    }
}
