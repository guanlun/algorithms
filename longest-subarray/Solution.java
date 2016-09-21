static int maxLength(int[] a, int k) {
    int len = a.length;
    int maxLen = 0;

    int sum = 0;

    int left = 0, right = 0;

    while (right < len) {
        sum += a[right];

        if (sum <= k) {
            int currLen = right - left + 1;

            if (currLen > maxLen) {
                maxLen = currLen;
            }
        } else {
            while (sum > k) {
                sum -= a[left];
                left++;
            }
        }

        right++;
    }

    return maxLen;
}
