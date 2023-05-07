package PalindromicSubstring.countPalindromicSubString;

public class CountPalindromicSubStrings {
    public static int countPalindromicSubstring(String str) {
        boolean dp[][] = new boolean[str.length()][str.length()];
        int count = 0;

        for (int g = 0; g < dp.length; g++) { //every diagonal start with first row and ends at last column
            for (int i = 0, j = g; j < dp.length; j++, i++) {  //j < dp.length  where diagonal ends
                if (g == 0) {
                    dp[i][j] = true;
                } else if (g == 1) {
                    if (str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if (str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                }
                if (dp[i][j] == true) {
                    count++;
                }
            }

        }
        return count;

    }

    public static void main(String[] args) {
        String str="abccbc";
        System.out.println(countPalindromicSubstring(str));
    }
}
