public class TicTacToe {
    private int size;
    private int[][] board;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        size = n;
        board = new int[n][n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        this.board[row][col] = player;
        
        if (hasEntireRow(col, player)
            || hasEntireCol(row, player)
            || hasDiagon(row, col, player)) {
            return player;    
        } else {
            return 0;
        }
    }
    
    private boolean hasEntireRow(int col, int player) {
        for (int i = 0; i < this.size; i++) {
            if (this.board[i][col] != player) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean hasEntireCol(int row, int player) {
        for (int i = 0; i < this.size; i++) {
            if (this.board[row][i] != player) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean hasDiagon(int row, int col, int player) {
        if ((row != col) && (this.size - row - 1 != col)) {
            return false;
        }
        
        boolean won = true;
        
        for (int i = 0; i < this.size; i++) {
            if (this.board[i][i] != player) {
                won = false;
                break;
            }
        }
        
        if (won) {
            return true;
        }
        
        won = true;
        
        for (int i = 0; i < this.size; i++) {
            if (this.board[this.size - i - 1][i] != player) {
                won = false;
                break;
            }
        }
        
        return won;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
