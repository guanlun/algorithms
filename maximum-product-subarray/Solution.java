public class Solution {
    public int maxProduct(int[] nums) {
        int maxPositive = 1;
        int minNegative = 1;

        int maxProd = -Integer.MAX_VALUE;

        for (int n : nums) {
            if (n > 0) {
                maxPositive *= n;
                minNegative *= n;
            } else if (n < 0) {
                int mp = maxPositive;

                maxPositive = minNegative * n;
                minNegative = mp * n;
            } else {
                maxPositive = 0;
                minNegative = 0;
            }

            maxProd = Math.max(maxProd, maxPositive);

            if (maxPositive <= 0) {
                maxPositive = 1;
            }
        }

        return maxProd;
    }
}
