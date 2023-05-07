package minimum_Number_Of_jumps;
////https://leetcode.com/problems/jump-game-ii/
public class MinJumps_DP1 {

    public static int minJumps(int[] arr) {

        int min = Integer.MAX_VALUE;
        int[] dp = new int[arr.length];

        for (int i = 1; i < arr.length; i++) {
            dp[i] = min;
            for (int j = 0; j < i; j++) {
                if (i <= j + arr[j] && dp[j] != min) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[arr.length - 1];

    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
        int n = arr.length;
        System.out.println(minJumps(arr));
    }
}
