public class Solution {
    public List<String> summaryRanges(int[] nums) {
        int length = nums.length;
        ArrayList<String> ranges = new ArrayList<String>();
        
        if (length == 0) {
            return ranges;
        } else if (length == 1) {
            ranges.add("" + nums[0]);
            return ranges;
        }
        
        int prev = nums[0];
        int curr = nums[1];
        int startOfRange = nums[0];
        
        for (int i = 1; i < length; i++) {
            curr = nums[i];
            
            if (curr == (prev + 1)) {
                // Range continues
                prev = curr;
            } else {
                // Range breaks
                if (startOfRange == prev) {
                    ranges.add("" + prev);
                } else {
                    ranges.add(startOfRange + "->" + prev);
                }
                
                startOfRange = curr;
                prev = curr;
            }
        }
        
        if (startOfRange == prev) {
            ranges.add("" + prev);
        } else {
            ranges.add(startOfRange + "->" + prev);
        }
        
        return ranges;
    }
}
