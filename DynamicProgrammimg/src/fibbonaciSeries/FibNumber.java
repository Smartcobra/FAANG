package fibbonaciSeries;

import java.util.Scanner;

public class FibNumber {
    public int getFib(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        if(n==0||n==1) return n;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output

        FibNumber m = new FibNumber();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(m.getFib(n));

    }
}
