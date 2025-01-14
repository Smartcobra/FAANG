package Sudoku;

///https://leetcode.com/problems/sudoku-solver/
public class Sudoku_new {
    public int check = 0;

    public void solveSudoku(char[][] board) {
        check = 0;
        solve(board, 0, 0);

    }

    public void solve(char[][] board, int row, int col) {
        if (row == 9) {
            check = 1;
            return;
        } else if (board[row][col] != '.') {
            if (col != 8) {
                solve(board, row, col + 1);
            } else {
                solve(board, row + 1, 0);
            }
        } else {
            for (char ch = '1'; ch <= '9'; ch++) {
                if (isValid(board, row, col, ch)) {
                    board[row][col] = ch;
                    if (col != 8) {
                        solve(board, row, col + 1);
                    } else {
                        solve(board, row + 1, 0);
                    }

                    if (check == 1) return;// if we dont put check while backtracking all will be reverted,
                    board[row][col] = '.';
                }
            }
        }
    }

    public boolean isValid(char[][] board, int row, int col, char ch) {

        for (int j = 0; j < 9; j++) {
            if (board[row][j] == ch) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == ch) {
                return false;
            }
        }

        int sRow = row / 3 * 3;
        int sCol = col / 3 * 3;

        for (int i = sRow; i < sRow + 3; i++) {
            for (int j = sCol; j < sCol + 3; j++) {
                if (board[i][j] == ch) {
                    return false;
                }
            }
        }
        return true;

    }

}
