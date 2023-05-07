package lcs;

public class LCS_Recursive {

    public int getLcs(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int m = s1.length;
        int n = s2.length;

        int ans = getLcsHelper(s1, s2, m, n);

        return ans;
    }

    private int getLcsHelper(char[] s1, char[] s2, int m, int n) {
        if ( m== 0 || n== 0) {
            return 0;
        }

        if (s1[m - 1] == s2[n - 1]) {
            return 1 + getLcsHelper(s1, s2, m - 1, n - 1);
        } else {
            return Math.max(getLcsHelper(s1, s2, m - 1, n), getLcsHelper(s1, s2, m, n - 1));
        }
    }

    public static void main(String[] args) {
        LCS_Recursive lr = new LCS_Recursive();
        String s1= "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println(lr.getLcs(s1,s2));
    }

}

