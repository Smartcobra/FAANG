package Sudoku;

public class Sudoku_MoreReadable {
    private static final int SIZE = 9;
    private static final int SUBGRID_SIZE = 3;
    private static final char EMPTY_CELL = '.';

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == EMPTY_CELL) {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isValid(board, row, col, ch)) {
                            board[row][col] = ch;
                            if (solve(board)) {
                                return true;
                            }
                            board[row][col] = EMPTY_CELL;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char ch) {
        return !usedInRow(board, row, ch) &&
                !usedInColumn(board, col, ch) &&
                !usedInSubgrid(board, row - row % SUBGRID_SIZE, col - col % SUBGRID_SIZE, ch);
    }

    private boolean usedInRow(char[][] board, int row, char ch) {
        for (int col = 0; col < SIZE; col++) {
            if (board[row][col] == ch) {
                return true;
            }
        }
        return false;
    }

    private boolean usedInColumn(char[][] board, int col, char ch) {
        for (int row = 0; row < SIZE; row++) {
            if (board[row][col] == ch) {
                return true;
            }
        }
        return false;
    }

    private boolean usedInSubgrid(char[][] board, int startRow, int startCol, char ch) {
        for (int row = 0; row < SUBGRID_SIZE; row++) {
            for (int col = 0; col < SUBGRID_SIZE; col++) {
                if (board[row + startRow][col + startCol] == ch) {
                    return true;
                }
            }
        }
        return false;
    }


}
