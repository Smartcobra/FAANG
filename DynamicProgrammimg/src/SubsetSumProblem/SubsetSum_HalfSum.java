package SubsetSumProblem;

import java.util.Arrays;
import java.util.stream.Stream;

public class SubsetSum_HalfSum {
    public boolean getHalfSum(int arr[]) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        int half_sum = sum / 2;

        boolean dp[][] = new boolean[n + 1][half_sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= half_sum; j++) {
                if (j>=arr[i - 1]) {  // j is the current sum and should be greater than the present value
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i-1]];  //include
                } else {
                    dp[i][j] = dp[i - 1][j];  //exclude

                }
            }
        }
        //Stream.of(dp).flatMap(Stream::of).forEach(System.out::println);
        Stream.of(dp).map(Arrays::toString).forEach(System.out::println);
        return dp[n][half_sum];
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 5, 8};
        SubsetSum_HalfSum ssh = new SubsetSum_HalfSum();
        System.out.println(ssh.getHalfSum(arr));
    }
}
