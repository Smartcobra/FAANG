package N_Queens;

import java.util.ArrayList;
import java.util.List;

public class NQueenLeetcode {

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        nQueen(board, 0, ans);
        return ans;
    }

    private void nQueen(char[][] board, int row, List<List<String>> ans) {
        int n = board.length;
        if (row == n) {
            List<String> l = new ArrayList<>();
            for (char[] chars : board) {
                String str = new String(chars);
                l.add(str);
            }
            ans.add(l);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueen(board, row + 1, ans);
                board[row][j] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;

        // Check if there's a queen in the same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
// Check if there's a queen in the NW direction
        /*
Row:    0    1    2    3
Col:    0    1    2    3

        Q    .    .    .
        .    .    .    .
        .    .    ?    .   start from (2,2)
        .    .    .    .
         */


        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        /*
 // Check if there's a queen in the NE direction
Row:    0    1    2    3
Col:    0    1    2    3

        .    .    Q    .
        .    .    .    .
        .    ?    .    .
        .    .    .    .

         */
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }


}
