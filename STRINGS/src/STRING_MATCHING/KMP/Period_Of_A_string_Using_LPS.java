package STRING_MATCHING.KMP;

import java.util.Arrays;

public class Period_Of_A_string_Using_LPS {

    public static  int solve(String A) {
        int n = A.length();
        int[] lps = getLPS(A);
        return n - lps[n - 1];
    }

    public static int[] getLPS(String A) {
        int n = A.length();
        int x = 0;
        int[] lps = new int[n];

        lps[0] = 0;
        for (int i = 1; i < n; i++) {
            x = lps[i - 1];
            while (A.charAt(i) != A.charAt(x)) {
                if (x == 0) {
                    x = -1;
                    break;
                }
                x = lps[x - 1];
            }
            lps[i] = x + 1;
        }

        return lps;
    }

    public static void main(String[] args) {
        String s = "abababab";
       // System.out.println(Arrays.toString(getLPS(s)));
        System.out.println(solve(s));
    }
}
