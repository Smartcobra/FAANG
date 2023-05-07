package editDistance;

import java.util.Arrays;

public class EditDistance_DP {
    public static int getEditDistance(String str1, String str2) {

        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n + 1][m + 1];


        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        int cd = 1 + dp[i - 1][j]; //delete
                        int ci = 1 + dp[i][j - 1]; //insert
                        int cr = 1 + dp[i - 1][j - 1]; //replace
                        dp[i][j] = Math.min(cd, Math.min(ci, cr));
                    }
                }

            }
        }
        return dp[dp.length - 1][dp[0].length - 1];

    }

    public static void main(String[] args) {

        String str1 = "voldemort";
        String str2 = "dumbledore";

        System.out.println(getEditDistance(
                str1, str2));
    }
}
