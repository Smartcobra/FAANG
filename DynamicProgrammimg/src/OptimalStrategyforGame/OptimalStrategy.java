package OptimalStrategyforGame;

public class OptimalStrategy {

    public static int getOptimalStrategy(int arr[]) {
        int dp[][] = new int[arr.length][arr.length];

        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp.length; j++, i++) {
                if (g == 0) {
                    dp[i][j] = arr[i];
                } else if (g == 1) {
                    dp[i][j] = Math.max(arr[i], arr[j]);
                } else {

                    int val1 = arr[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]);
                    ///you took i , remain i+1->j ,opponent took i+1, remain i+2 ->j
                    ///             remain i+1->j ,opponent took j,   remain i+1 ->j-1
                    int val2 = arr[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]);
                    ///you took j , remain i->j-1 ,opponent took i, remain i+1 ->j-1
                    ///             remain i->j-1 ,opponent took j-1,   remain i ->j-2
                    dp[i][j] = Math.max(val1, val2);

                }
            }
        }
        return dp[0][arr.length - 1];

    }

    public static void main(String[] args) {
        int arr1[] = {8, 15, 3, 7};
        System.out.println(
                ""
                        + getOptimalStrategy(arr1));

        int arr2[] = {2, 2, 2, 2};
        System.out.println(
                ""
                        + getOptimalStrategy(arr2));

        int arr3[] = {20, 30, 2, 2, 2, 10};
        System.out.println(
                ""
                        + getOptimalStrategy(arr3));
    }

}
