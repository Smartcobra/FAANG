package PalindromicSubstring.longestPlaindrome;

public class PrintLongestPalindromicSubstring {
    public static int printLongestPalindromicSubString(String str) {
        boolean dp[][] = new boolean[str.length()][str.length()];
        int len = 0;
        int start = 0;
        int end = 0;
        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp.length; j++, i++) {
                if (g == 0) {
                    dp[i][j] = true;
                } else if (g == 1) {
                    if (str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] == true) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                }

                if (dp[i][j]) {
                    len = g + 1;
                    start = i;
                    end=j;
                }
            }

        }

        System.out.println(str.substring(start,end+1));
        return len;
    }

    public static void main(String[] args) {

        String str = "forgeeksskeegfor";
        System.out.print("Length is: "
                + printLongestPalindromicSubString(str));
    }
}
