package Unique_Binary_Search_Trees;
////https://leetcode.com/problems/unique-binary-search-trees/

/*
 *  Use of catalan Number
 * */
public class UniqueBST {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {    //C4 = C0C3 + C1C2+ C2C1 + C3C0
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];

    }

}

