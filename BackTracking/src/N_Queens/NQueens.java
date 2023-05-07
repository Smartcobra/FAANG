package N_Queens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class NQueens {
    ArrayList<ArrayList<String>> result = new ArrayList<>();

    public ArrayList<ArrayList<String>> solveNQueens(int A) {
        String[][] input = new String[A][A];

        for(int i=0;i<A;i++){
            for(int j=0;j<A;j++){
                input[i][j]=".";
            }
        }
        nqueens(A, input, 0);
        return result;
    }

    private void nqueens(int A, String[][] input, int i) {
        if (i == A) {
            for (String[] strings : input) {
                ArrayList<String> list = new ArrayList<>(Arrays.asList(strings));
                result.add(list);
            }
            return;
        }

        for (int j = 0; j < A; j++) {
            if (check(input, i, j)) {
                input[i][j] = "Q";
                nqueens(A, input, i + 1);
                input[i][j] = ".";
            }
        }
    }

    public boolean check(String[][] input, int i, int j) {
        for (int r = 0; r < i; r++) {
            if (Objects.equals(input[r][j], "Q")) {
                return false;
            }
        }

        int r = i;
        int c = j;
        while (r >= 0 && c >= 0) {
            if (Objects.equals(input[r--][c--], "Q")) {
                return false;
            }
        }
        int r1 = i;
        int c1 = j;
        while (r1 >= 0 && c1 < input.length) {
            if (Objects.equals(input[r1--][c1++], "Q")) {
                return false;
            }
        }

        return true;

    }

    ///[..Q. Q... ...Q .Q.. ] [.Q.. ...Q Q... ..Q. ]

    public static void main(String[] args) {
        NQueens nq= new NQueens();
        System.out.println(nq.solveNQueens(4));
    }
}
