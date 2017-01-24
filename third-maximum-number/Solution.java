public class Solution {
    public int thirdMax(int[] nums) {
        Integer max = null,
            max2 = null,
            max3 = null;

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];

            if (max == null || n > max) {
                max3 = max2;
                max2 = max;
                max = n;
            } else if (n == max) {
                continue;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n == max2) {
                continue;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }

        if (max3 == null) {
            return max;
        } else {
            return max3;
        }
    }
}
