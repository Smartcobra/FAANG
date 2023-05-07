package CountingBooleanParenthesization;

public class CountBooleanParenthesization_Recursive {

    public int getWaysTrue(String str) {
        return getWaysTrueHelper(str, 0, str.length() - 1, true);

    }

    private int getWaysTrueHelper(String str, int i, int j, boolean isTrue) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            if (isTrue) {
                return ('T' == str.charAt(i)) ? 1 : 0;
            } else {
                return ('F' == str.charAt(i)) ? 1 : 0;
            }
        }
        int ans = 0;
        for (int k = i + 1; k < j; k = k + 2) {
            int leftTrue = getWaysTrueHelper(str, i, k - 1, true);
            int leftFalse = getWaysTrueHelper(str, i, k - 1, false);
            int rightTrue = getWaysTrueHelper(str, k + 1, j, true);
            int rightFalse = getWaysTrueHelper(str, k + 1, j, false);

            if (str.charAt(k) == '^') {
                /// for 'XOR' operator
                if (isTrue) {
                    ans = ans + leftTrue * rightFalse + rightTrue * leftFalse;
                } else {
                    ans = ans + leftTrue * rightTrue + rightFalse * leftFalse;
                }
                /// for 'OR' operator
            } else if (str.charAt(k) == '|') {
                if (isTrue) {
                    ans = ans + leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue;
                } else {
                    ans = ans + leftFalse * rightFalse;
                }
                /// for & operator
            } else {

                if (isTrue) {
                    ans = ans + leftTrue * rightTrue;
                } else {
                    ans = ans + leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse;
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        CountBooleanParenthesization_Recursive cr= new CountBooleanParenthesization_Recursive();

            String symbols = "TTFT";
            String operators = "|&^";
            StringBuilder S = new StringBuilder();
            int j = 0;

            for (int i = 0; i < symbols.length(); i++)
            {
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
