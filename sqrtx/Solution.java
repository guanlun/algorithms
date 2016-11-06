public class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        long left = 1;
        long right = x;

        while (left < right) {
            long mid = left + (right - left) / 2;

            if (mid * mid == x) {
                return (int)mid;
            } else if (mid * mid < x) {
                left = (int)(mid + 1);
            } else {
                right = (int)(mid - 1);
            }
        }

        if (left * left <= x) {
            return (int)left;
        } else {
            return (int)(left - 1);
        }
    }
}
