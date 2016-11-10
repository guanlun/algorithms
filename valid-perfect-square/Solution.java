public class Solution {
    public boolean isPerfectSquare(int num) {
        long left = 0;
        long right = num;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (mid * mid == num) {
                return true;
            } else if (mid * mid > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}
