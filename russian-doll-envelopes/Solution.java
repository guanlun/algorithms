public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int len = envelopes.length;
        if (len == 0) {
            return 0;
        }

        sortEnvelopes(envelopes, 0, len - 1);

        for (int[] e : envelopes) {
            System.out.println(e[0] + " " + e[1]);
        }

        int[] result = new int[len];

        result[0] = 1;

        for (int i = 1; i < len; i++) {
            int maxLen = 0;

            for (int j = 0; j < i; j++) {
                int[] currEnvelope = envelopes[i];
                int[] lastEnvelope = envelopes[j];

                if (currEnvelope[0] > lastEnvelope[0] && currEnvelope[1] > lastEnvelope[1]) {
                    int currLen = result[j];

                    if (currLen > maxLen) {
                        maxLen = currLen;
                    }
                }
            }

            result[i] = maxLen + 1;
        }

        int maxResult = 0;

        for (int r : result) {
            System.out.println(r);
            if (r > maxResult) {
                maxResult = r;
            }
        }

        return maxResult;
    }

    private void sortEnvelopes(int[][] envelopes, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        int pivot0 = envelopes[mid][0];
        int pivot1 = envelopes[mid][1];

        int i = left, j = right;

        while (i < j) {
            while (envelopes[i][0] < pivot0 || (envelopes[i][0] == pivot0 && envelopes[i][1] < pivot1)) {
                i++;
            }

            while (envelopes[j][0] > pivot0 || (envelopes[j][0] == pivot0 && envelopes[j][1] > pivot1)) {
                j--;
            }

            if (i <= j) {
                int temp0 = envelopes[i][0];
                int temp1 = envelopes[i][1];
                envelopes[i][0] = envelopes[j][0];
                envelopes[i][1] = envelopes[j][1];
                envelopes[j][0] = temp0;
                envelopes[j][1] = temp1;

                i++;
                j--;
            }
        }

        if (left < j) {
            sortEnvelopes(envelopes, left, j);
        }

        if (i < right) {
            sortEnvelopes(envelopes, i, right);
        }
    }
}
