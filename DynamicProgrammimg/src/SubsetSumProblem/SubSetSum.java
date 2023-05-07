package SubsetSumProblem;

public class SubSetSum {

    public boolean isSUMPresent(int arr[], int sum) {
        int n = arr.length;
        boolean dp[][] = new boolean[n + 1][sum + 1];

//        for (int i = 0; i <= sum; i++) {
//            dp[0][1] = false;
//        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    // include ith element and reduce the current value from the sum
                    dp[i][j] = dp[i - 1][j] || dp[i-1][j - arr[i - 1]];
                } else {// current sum is less than the current element ( current sum means j, varies from 0 to sum
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int arr[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        SubSetSum ss = new SubSetSum();
        System.out.println(ss.isSUMPresent(arr, sum));
    }
}
