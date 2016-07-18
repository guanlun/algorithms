public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] lookup;
        
        for (int row = 0; row < 9; row++) {
            lookup = new boolean[9];

            for (int col = 0; col < 9; col++) {
                if (foundDuplicate(board, row, col, lookup)) {
                    return false;
                }
            }
        }
        
        for (int col = 0; col < 9; col++) {
            lookup = new boolean[9];
            
            for (int row = 0; row < 9; row++) {
                if (foundDuplicate(board, row, col, lookup)) {
                    return false;
                }
            }
        }
        
        for (int startRow = 0; startRow < 9; startRow += 3) {
            for (int startCol = 0; startCol < 9; startCol += 3) {
                lookup = new boolean[9];
                
                for (int row = startRow; row < startRow + 3; row++) {
                    for (int col = startCol; col < startCol + 3; col++) {
                        if (foundDuplicate(board, row, col, lookup)) {
                            return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }
    
    private boolean foundDuplicate(char[][] board, int row, int col, boolean[] lookup) {
        char elem = board[row][col];
        
        if (elem == '.') {
            return false;
        }
        
        int num = Character.getNumericValue(elem) - 1;
                
        if (lookup[num] == true) {
            return true;
        }
        
        lookup[num] = true;
        return false;
    }
}
