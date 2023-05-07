package Check_Two_Bracket_Expressions;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

    public static int solve(String A, String B) {
        char[] strA = calculateProperSign(A);
        char[] strB = calculateProperSign(B);

        for (int i = 0; i < strA.length; i++) {
            if (strA[i] != strB[i]) {
                return 0;
            }
        }
        return 1;
    }

    public static  char[] calculateProperSign(String str) {
        int n = str.length();
        Stack<Character> globalOperators = new Stack<>();
        char[] output = new char[26];
        Arrays.fill(output, '+');
        char localOperator = '+';

        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);

            if (c == '-' || c == '+') {
                if (globalOperators.isEmpty()) {
                    localOperator = c;
                } else {
                    localOperator = getProperSign(globalOperators.peek(), c);
                }
                continue;
            }

            if (c == '(') {
                globalOperators.push(localOperator);
                continue;
            }

            if (c == ')') {
                globalOperators.pop();
                continue;
            }

            output[c - 'a'] = localOperator;

        }
        return output;
    }

    public static char getProperSign(char O1, char O2) {
        if ((O1 == '-' && O2 == '+') || (O1 == '+' && O2 == '-')) {
            return '-';
        }
        return '+';
    }

    public static void main(String[] args) {
        String A = "a+b-c+d-e-f";
        String B = "(a+b-c-d-e+f)";
        System.out.println(solve(A,B));
    }
}
