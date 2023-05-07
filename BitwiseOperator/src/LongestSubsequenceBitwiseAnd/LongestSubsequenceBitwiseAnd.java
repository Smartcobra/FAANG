package LongestSubsequenceBitwiseAnd;

public class LongestSubsequenceBitwiseAnd {

    public static int maximumSum(int arr[], int N) {
        int ans = 0;
        for (int bit = 0; bit < 32; bit++) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if ((arr[i] & (1 << bit)) == 1) {
                    sum += arr[i];
                }
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
