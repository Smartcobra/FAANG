package Number_of_islands;

import java.util.ArrayList;

////https://www.scaler.com/academy/mentee-dashboard/class/35035/homework/problems/4702?navref=cl_tt_lst_nm
public class Number_of_islands_compact {
    static int[] x = {-1, 0, 1, 0, -1, 1, -1, 1};
    static int[] y = {0, -1, 0, 1, -1, 1, 1, -1};
    public int solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int c = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) {
                    c++;
                    dfs(A, i, j, n, m);
                }
            }
        }
        return c;
    }

    private void dfs(int[][] matrix, int i, int j, int row, int col) {
        if (i < 0 || j < 0 || i >= row || j >= col || matrix[i][j] == 0) {
            return;
        }

        matrix[i][j] = 0;// mark visited

        for (int k = 0; k < 8; k++) {
            dfs(matrix, i + x[k], j + y[k], row, col);
        }

    }

    public static void main(String[] args) {


        Number_of_islands_compact ns = new Number_of_islands_compact();

        int[][] matrix = {
                {0, 0, 1, 0, 1, 0, 1, 0, 1},
                {0, 1, 0, 0, 0, 1, 0, 1, 0},
                {1, 1, 0, 1, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 1, 1, 0, 1, 0},
                {0, 0, 1, 0, 1, 1, 1, 1, 0},
                {1, 1, 0, 1, 1, 0, 1, 0, 0},
                {0, 0, 1, 1, 0, 1, 0, 0, 0}
        };

        System.out.println(ns.solve(matrix));
    }

}
