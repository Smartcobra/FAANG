package Range_Sum_Query;

public class Brutforce {

    public static long[] rangeSum(int[] A, int[][] B) {

        int n = A.length;
        int m = B.length;
        long[] ans = new long[m];


        for (int i = 0; i < m; i++) {
            int l = B[i][0]-1;
            int r = B[i][1];
            int sum = 0;
            for (int j = l; j < r; j++) {
                sum += A[j];
                ans[i] = sum;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] A = {7, 3, 1, 5, 5, 5, 1, 2, 4, 5};
        int[][] B = {{7, 10}, {3, 10}, {3, 5}, {1, 10}};

        long[] longs = rangeSum(A, B);

        for (int i = 0; i < longs.length; i++) {
            System.out.println(longs[i]);
        }

    }
}
