package Range_Sum_Query_2D;

public class Optimized {
    public static int sumRegion(int[][] arr, int row1, int col1, int row2, int col2) {

        int sum = 0;
        ///first find the prefixarr
        int R = arr.length;
        int C = arr[0].length;
        int[][] psa = new int[R][C];
        psa[0][0] = arr[0][0];
        for (int i = 1; i < C; i++) {
            psa[0][i] = arr[0][i] + psa[0][i - 1];
        }
        for (int i = 1; i < R; i++) {
            psa[i][0] = arr[i][0] + psa[i - 1][0];
        }

        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                psa[i][j] = psa[i][j - 1] + psa[i - 1][j] - psa[i - 1][j - 1] + arr[i][j];
            }

        }

         sum=psa[row2][col2];
        if(col1!=0){
            sum=sum-psa[row2][col1-1];
        }if(row1!=0){
            sum=sum-psa[row1-1][col2];

        }if(col1!=0 && row1!=0){
            sum=sum+psa[row1-1][col1-1];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2}
                , {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};

        System.out.println(sumRegion(matrix,2, 1, 4, 3));
    }
}
