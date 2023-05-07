package TWO_D_Matrix;

public class Create2DMatrix {

    public static int[][] generateMatrix(int N) {
        int[][] result = new int[N][N];

        int r1 = 0;
        int r2 = N - 1;
        int c1 = 0;
        int c2 = N - 1;
        int val = 1;

        while (r1 <= r2 && c1 <= c2) {

            for (int i = c1; i <= c2; i++) {
                result[r1][i] = val++;
            }

            for (int i = r1 + 1; i <= r2; i++) {
                result[i][c2] = val++;
            }

            if (r1 < r2 && c1 < c2) {
                for (int i = c2-1; i >=c1; i--) {
                    result[r2][i] = val++;
                }

                for (int i = r2-1; i >=r1; i--) {
                    result[i][c1] = val++;
                }
            }


            r1++;
            r2--;
            c1++;
            c2--;
        }

        return result;
    }

}
