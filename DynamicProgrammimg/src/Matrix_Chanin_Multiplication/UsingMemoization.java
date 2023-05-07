package Matrix_Chanin_Multiplication;

public class UsingMemoization {
    public int getMinMatrixChainOrderHelper(int arr[]) {
        int n = arr.length;
        int i = 1;
        int j = n - 1;
        int[][] dp = new int[arr.length][arr.length];

        return getMinMatrixChainOrderMemoization(arr, i, j, dp);
    }

    private int getMinMatrixChainOrderMemoization(int[] arr, int i, int j, int[][] dp) {
        if (i >= j) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        if (dp[i][j] == 0) {
           for (int k = i; k < j; k++) {
                int cost = getMinMatrixChainOrderMemoization(arr, i, k, dp)
                        + getMinMatrixChainOrderMemoization(arr, k + 1, j, dp)
                        + arr[i - 1] * arr[k] * arr[j];
                if (cost < min) {
                    min = cost;
                }
            }
            dp[i][j] = min;

        }

        return dp[i][j];
    }

    public static void main(String[] args) {
        UsingMemoization ur = new UsingMemoization();
       // int arr[] = new int[]{1, 2, 3, 4, 3};
       // int[] arr = { 10, 30, 5, 60 };
        int[] arr = {40, 20, 30, 10, 30};

        System.out.println(
                "Minimum number of multiplications is "
                        + ur.getMinMatrixChainOrderHelper(arr));
    }
}
