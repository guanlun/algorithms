public class Solution {
    public void rotate(int[][] matrix) {
        rotateOutmost(matrix, 0, matrix.length - 1);
    }
    
    private void rotateOutmost(int[][] matrix, int from, int to) {
        if (from >= to) {
            return;
        }

        int temp;
        for (int i = from; i < to; i++) {
            temp = matrix[from][i];
            
            matrix[from][i] = matrix[to - i + from][from];
            matrix[to - i + from][from] = matrix[to][to - i + from];
            matrix[to][to - i + from] = matrix[i][to];
            matrix[i][to] = temp;
        }
        
        rotateOutmost(matrix, from + 1, to - 1);
    }
}
