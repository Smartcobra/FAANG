package Matrix_Chanin_Multiplication;

public class UsingDynamicProgramming {
    public static int getMatrixChain(int arr[]) {
        int n = arr.length;
        int cost[][] = new int[n][n];
        int S[][] = new int[n][n];

        int j, min;

        for (int d = 1; d < n - 1; d++) {
            for (int i = 1; i < n - d; i++) {
                j = i + d;
                min = Integer.MAX_VALUE;
                for (int k = i; k <=j-1; k++) {
                    int q = cost[i][k] + cost[k + 1][j] + arr[i - 1] * arr[k] * arr[j];

                    if (q < min) {
                        min= q;
                        S[i][j] = k;
                    }
                }
                cost[i][j]=min;
            }
        }
        return cost[1][n - 1];
    }

    public static void main(String[] args) {
        //int arr[] = new int[]{1, 2, 3, 4, 3};
       // int[] arr = { 10, 30, 5, 60 };
        int[] arr = {40, 20, 30, 10, 30};
       // int[] arr = {5, 4, 6, 2, 7};
        System.out.println(
                "Minimum number of multiplications is "
                        + getMatrixChain(arr));
    }
}

