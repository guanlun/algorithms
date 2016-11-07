public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int height = A.length;
        int width = B[0].length;

        boolean[] emptyRowInA = new boolean[height];
        boolean[] emptyColInB = new boolean[width];

        for (int row = 0; row < A.length; row++) {
            boolean isEmpty = true;
            for (int col = 0; col < A[0].length; col++) {
                if (A[row][col] != 0) {
                    isEmpty = false;
                    break;
                }
            }

            emptyRowInA[row] = isEmpty;
        }

        for (int col = 0; col < B[0].length; col++) {
            boolean isEmpty = true;
            for (int row = 0; row < B.length; row++) {
                if (B[row][col] != 0) {
                    isEmpty = false;
                    break;
                }
            }

            emptyColInB[col] = isEmpty;
        }

        int[][] result = new int[height][width];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (emptyRowInA[row] || emptyColInB[col]) {
                    result[row][col] = 0;
                    continue;
                }

                int sum = 0;

                for (int i = 0; i < A[0].length; i++) {
                    sum += A[row][i] * B[i][col];
                }

                result[row][col] = sum;
            }
        }

        return result;
    }
}
