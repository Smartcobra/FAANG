package eggDropping;


public class EggDroppingDP {

    public int solveEggDropping(int e, int f) {
        int dp[][] = new int[e + 1][f + 1];
        for (int i = 1; i <= e; i++) {
            for (int j = 1; j <= f; j++) {
                if (i == 1) {
                    dp[i][j] = j;
                } else if (j == 1) {
                    dp[i][j] = 1;
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int mj = j - 1, pj = 0; mj >= 0; mj--, pj++) {
                        int val1 = dp[i][mj]; //eggs servives
                        int val2 = dp[i - 1][pj]; //eggs breaks
                        int val = Math.max(val1, val2);
                        min = Math.min(min, val);
                    }
                    dp[i][j] = min + 1;
                }
            }
        }
        return dp[e][f];
    }

    public static void main(String[] args) {
        EggDroppingDP dp = new EggDroppingDP();
        int n = 2, k = 36;
        System.out.print(dp.solveEggDropping(n, k));
    }
}
