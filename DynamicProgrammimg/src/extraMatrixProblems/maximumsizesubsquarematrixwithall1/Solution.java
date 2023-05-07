package extraMatrixProblems.maximumsizesubsquarematrixwithall1;

import java.util.Scanner;

public class Solution {
    public static int getMaxSubMatrixWith_1(int[][] A) {
        int[][] dp = new int[A.length][A[0].length];
        int ans = Integer.MIN_VALUE;


        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {

                if (i == dp.length - 1 && j == dp[0].length - 1) {
                    dp[i][j] = A[i][j];

                } else if (i == dp.length - 1) {
                    dp[i][j] = A[i][j];

                } else if (j == dp[0].length - 1) {
                    dp[i][j] = A[i][j];

                } else {
                    if (A[i][j] == 0) {
                        dp[i][j] = 0;
                    } else {
                        int min = Math.min(dp[i][j + 1], Math.min(dp[i + 1][j + 1], dp[i + 1][j]));
                        dp[i][j] = 1 + min;

                        if (dp[i][j] > ans) {
                            ans = dp[i][j];
                        }

                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt();
//        int n = sc.nextInt();
//        int arr[][] = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                arr[i][j] = sc.nextInt();
//            }
//        }
//        System.out.println(getMatrixWith1(arr));


        int M[][] = {{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(getMaxSubMatrixWith_1(M));
    }
}