package optimalBinarySearchTree;

import java.util.Scanner;

public class OptimalBST {
    public static int getOptimalBST(int[] keys, int[] frequency, int n) {
        int dp[][] = new int[n][n];

        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp.length; j++, i++) {
                if (g == 0) {
                    dp[i][j] = frequency[i];
                } else if (g == 1) {
                    int f1 = frequency[i];
                    int f2 = frequency[j];
                    dp[i][j] = Math.min(f1 + 2 * f2, f2 + 2 * f1);
                } else {
                    int min = Integer.MAX_VALUE;
                    int fs = 0;
                    for (int f = i; f <= j; f++) {
                        fs += frequency[f];
                    }
                    for (int k = 0; k <= j; k++) {
                        int left = k == i ? 0 : dp[i][k - 1];
                        int right = k == j ? 0 : dp[k + 1][j];

                        if (left + right + fs < min) {
                            min = left + right + fs;
                        }
                    }
                    dp[i][j] = min;
                }
            }
        }

        return dp[0][n - 1];


    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//
//        int[] keys = new int[n];
//        int[] frequency = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            keys[i] = sc.nextInt();
//        }
//
//
//        for (int i = 0; i < n; i++) {
//            frequency[i] = sc.nextInt();
//        }
//
//        System.out.println(getOptimalBST(keys, frequency, n));

        int keys[] = {10, 12, 20};
        int freq[] = {34, 8, 50};
        int n = keys.length;
        System.out.println(getOptimalBST(keys, freq, n));


    }


}
