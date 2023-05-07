package Max_Sum_Without_Adjacent_Elements;

import java.util.ArrayList;
/////Space Optimization
public class Max_Sum_Without_Adjacent_Elements2 {
    public static int adjacent(ArrayList<ArrayList<Integer>> A) {
        int n = A.get(0).size();
        if (n == 0)
            return 0;
        ArrayList<Integer>  first=A.get(0);
        ArrayList<Integer> second=A.get(1);

        int[] dp = new int[n + 1];
        dp[0] = Math.max(first.get(0), second.get(0));
        if (n <= 1) {
            return dp[0];
        }
        dp[1]=Math.max(first.get(1), second.get(1));
        dp[1] = Math.max(dp[0],dp[1] );


        for (int i = 2; i <n; i++) {
            dp[i]=Math.max(first.get(i),second.get(i));
            dp[i]=dp[i]+dp[i-2];
            dp[i] = Math.max(dp[i - 1], dp[i]);
        }
        return dp[n - 1];
    }

}
