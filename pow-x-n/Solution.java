public class Solution {
    private double powIter(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double sqrt = powIter(x, n / 2);

        if (n % 2 == 0) {
            return sqrt * sqrt;
        } else {
            return sqrt * sqrt * x;
        }
    }

    public double myPow(double x, int n) {
        double result = 1;

        if (n == 0) {
            return 1;
        } else if (n > 0) {
            return powIter(x, n);
        } else {
            return 1 / powIter(x, -n);
        }
    }
}
