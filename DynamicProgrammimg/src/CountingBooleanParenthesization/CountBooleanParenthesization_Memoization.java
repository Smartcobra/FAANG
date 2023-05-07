package CountingBooleanParenthesization;

import java.util.Arrays;

public class CountBooleanParenthesization_Memoization {

    int dp[][][] = new int[1001][1001][2];


    public int getWaysTrue(String str) {

        for(int row [][]:dp){
            for(int col[]:row){
                Arrays.fill(col,-1);
            }
        }
        return getWaysTrueHelper(str, 0, str.length() - 1, 1);

    }

    private int getWaysTrueHelper(String str, int i, int j, int isTrue) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            if (isTrue == 1) {
                return ('T' == str.charAt(i)) ? 1 : 0;
            } else {
                return ('F' == str.charAt(i)) ? 1 : 0;
            }
        }
        if (dp[i][j][isTrue] != -1) {
            return dp[i][j][isTrue];
        }

        int ans = 0;
        for (int k = i + 1; k < j; k = k + 2) {
            int leftTrue = getWaysTrueHelper(str, i, k - 1, 1);
            int leftFalse = getWaysTrueHelper(str, i, k - 1, 0);
            int rightTrue = getWaysTrueHelper(str, k + 1, j, 1);
            int rightFalse = getWaysTrueHelper(str, k + 1, j, 0);

            if (str.charAt(k) == '^') {
                /// for 'XOR' operator
                if (isTrue == 1) {
                    ans = ans + leftTrue * rightFalse + rightTrue * leftFalse;
                } else {
                    ans = ans + leftTrue * rightTrue + rightFalse * leftFalse;
                }
                /// for 'OR' operator
            } else if (str.charAt(k) == '|') {
                if (isTrue == 1) {
                    ans = ans + leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue;
                } else {
                    ans = ans + leftFalse * rightFalse;
                }
                /// for & operator
            } else {

                if (isTrue == 1) {
                    ans = ans + leftTrue * rightTrue;
                } else {
                    ans = ans + leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse;
                }
            }

        }
        dp[i][j][isTrue] = ans;
        return dp[i][j][isTrue];
    }

    public static void main(String[] args) {
        CountBooleanParenthesization_Memoization cr = new CountBooleanParenthesization_Memoization();

        //String symbols = "TTFT";
        //String operators = "|&^";

        String symbols ="TFT";
        String operators  ="^&";

        StringBuilder S = new StringBuilder();
        int j = 0;

        for (int i = 0; i < symbols.length(); i++) {
            S.append(symbols.charAt(i));
            if (j < operators.length())
                S.append(operators.charAt(j++));
        }

        // We obtain the string  T|T&F^T
        int N = S.length();

        // There are 4 ways
        // ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T) and
        // (T|((T&F)^T))
        System.out.println(cr.getWaysTrue(S.toString()));

    }
}
