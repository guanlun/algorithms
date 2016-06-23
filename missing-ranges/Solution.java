public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int length = nums.length;
        
        int last = lower - 1;
        
        ArrayList<String> result = new ArrayList<String>();
        
        for (int i = 0; i <= length; i++) {
            int curr;
            if (i == length) {
                curr = upper + 1;
            } else {
                curr = nums[i];
            }
            
            if (curr == last + 2) {
                result.add((curr - 1) + "");
            } else if (curr > last + 2) {
                result.add((last + 1) + "->" + (curr - 1));
            }
            
            last = curr;
        }
        
        return result;
    }
}
