package N_Queens;

import java.util.ArrayList;
///https://www.scaler.com/academy/mentee-dashboard/class/35029/assignment/problems/141/?navref=cl_pb_nv_tb

public class NQueens_Scalar {
    ArrayList<ArrayList<String>> result = new ArrayList<>();

    public ArrayList<ArrayList<String>> solveNQueens(int A) {
        char[][] input = new char[A][A];
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < A; j++) {
                input[i][j] = '.';
            }
        }
        nqueens(A, input, 0);
        return result;
    }

    private ArrayList<String> createBoard(char[][] board) {
        ArrayList<String> l = new ArrayList<>();
        for (char[] chars : board) {
            String s = new String(chars);
            l.add(s);
        }
        return l;
    }


    private void nqueens(int A, char[][] input, int i) {
        if (i == A) {   // i is the row where we start placing
            result.add(createBoard(input));
            return;
        }

        for (int j = 0; j < A; j++) {
            if (check(input, i, j)) {
                input[i][j] = 'Q';
                nqueens(A, input, i + 1);
                input[i][j] = '.';
            }
        }
    }

    public boolean check(char[][] input, int i, int j) {
        for (int r = 0; r < i; r++) {
            if (input[r][j] == 'Q') {
                return false;
            }
        }

        int r = i;
        int c = j;
        while (r >= 0 && c >= 0) {
            if (input[r--][c--] == 'Q') {
                return false;
            }
        }
        int r1 = i;
        int c1 = j;
        while (r1 >= 0 && c1 < input.length) {
            if (input[r1--][c1++] == 'Q') {
                return false;
            }
        }

        return true;


    }


    ///[..Q. Q... ...Q .Q.. ] [.Q.. ...Q Q... ..Q. ]

    public static void main(String[] args) {
        NQueens_Scalar nq = new NQueens_Scalar();
        System.out.println(nq.solveNQueens(4));
    }
}
