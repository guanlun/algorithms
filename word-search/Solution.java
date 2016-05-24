public class Solution {
    public boolean exist(char[][] board, String word) {
        int height = board.length;
        int width = board[0].length;
        
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (board[row][col] == word.charAt(0)) {
                    if (search(board, row, col, word, 0)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    private boolean search(
        char[][] board,
        int row,
        int col, 
        String word, 
        int pos) {
            
        if (pos >= word.length()) {
            return true;
        }
            
        if ((row < 0) || (col < 0) || (row >= board.length) || (col >= board[0].length)) {
            return false;
        }
        
        if (board[row][col] != word.charAt(pos)) {
            return false;
        }
        
        char value = board[row][col];
        
        board[row][col] = 0;
        
        boolean ret = (search(board, row, col - 1, word, pos + 1)
        || search(board, row - 1, col, word, pos + 1)
        || search(board, row, col + 1, word, pos + 1)
        || search(board, row + 1, col, word, pos + 1));
        
        board[row][col] = value;
        
        return ret;
    }
}
