package Make_String_Palindrome;

import java.util.Arrays;

public class UsingKMP {
    public static int solve(String str) {

        StringBuilder s = new StringBuilder();
        s.append(str);
        String rev = s.reverse().toString();
        s.reverse().append("$").append(rev);

        int lp[] =  getLPS(s.toString());

        return str.length() - lp[s.length() - 1];
    }

    public static int[] getLPS(String str) {
        int[] lps = new int[str.length()];
        int n=str.length();
        int idx = 0;
        lps[0] = 0;
        for (int i = 1; i < n; ) {
            if (str.charAt(i) == str.charAt(idx)) {
                lps[i] = idx + 1;
                i++;
                idx++;
            } else {
                if (idx != 0) {
                    idx = lps[idx - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static int[] computeLPSArray(String str){
        int n = str.length();
        int lps[] = new int[n];
        int i = 1, len = 0;
        lps[0] = 0; // lps[0] is always 0

        while (i < n){
            if (str.charAt(i) == str.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if (len != 0){
                    len = lps[len - 1];
                }
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {

          String str = "aaaaa";
        //  System.out.println(Arrays.toString(getLPS("AACECAAAA$AAAACECAA")));
         // System.out.println(Arrays.toString(computeLPSArray("AACECAAAA$AAAACECAA")));
            System.out.println(solve(str));

    }
}
