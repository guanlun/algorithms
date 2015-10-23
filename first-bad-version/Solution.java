public class Solution {
    public static long firstBadVersion(long n) {
        long left = 0;
        long right = n;
        long mid;
        
        while (true) {
            if (left == right) {
                if (isBadVersion(left)) {
                    return left;
                } else {
                    return right;
                }
            }
            
            mid = (left + right) / 2;
            System.out.println(mid);
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
    }

    private static boolean isBadVersion(long n) {
        return n >= 1702766719;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(2126753390));
    }

}

