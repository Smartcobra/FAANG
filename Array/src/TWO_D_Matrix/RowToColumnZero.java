package TWO_D_Matrix;

//You are given a 2D integer matrix A, make all the elements in a row or column zero if the A[i][j] = 0. Specifically, make entire ith row and jth column zero.

public class RowToColumnZero {

    public static int[][] solve(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        boolean flag = false;

        for (int i = 0; i < N; i++) {
            flag = false;
            for (int j = 0; j < M; j++) {
                if (A[i][j] == 0) {
                    flag = true;
                }
            }
            if (flag) {
                for (int j = 0; j < M; j++) {
                    if (A[i][j] != 0) {
                        A[i][j] = -1;
                    }
                }
            }
        }
        ///////for col
        for (int j = 0; j < M; j++) {
            flag = false;
            for (int i = 0; i < N; i++) {
                if (A[i][j] == 0) {
                    flag = true;
                }
            }
            if (flag) {
                for (int i = 0; i < N; i++) {
                    if (A[i][j] != 0) {
                        A[i][j] = -1;
                    }
                }
            }
        }
        /////////////
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] == -1) {
                    A[i][j] = 0;
                }
            }
        }

        return A;
    }



    private static int[][] updateZero(int i, int j, int N, int M) {
        int[][] zero = new int[N][M];
        for (int k = 0; k < M; k++) {
            zero[i][k] = 0;
        }

        for (int k = 0; k < N; k++) {
            zero[k][j] = 0;
        }
        return zero;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2, 3, 4},
                {5, 6, 7, 0},
                {9, 2, 0, 4}};


        int[][] solve = solve(A);
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }

    }

}
