package Range_Sum_Query_2D;

public class BruteForce {
    public static int sumRegion(int[][] arr, int row1, int col1, int row2, int col2) {

        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                sum = sum + arr[i][j];
            }
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
