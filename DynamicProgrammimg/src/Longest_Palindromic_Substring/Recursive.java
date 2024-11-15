package Longest_Palindromic_Substring;

public class Recursive {

    public static boolean isPalindrome(int i, int j, String str) {
        if (i >= j) return true;

        if (str.charAt(i) == str.charAt(j)) {
            return isPalindrome(i + 1, j - 1, str);
        }

        return false;

    }

    public static int longest(String str) {
        int n = str.length();
        int startPoint = 0;
        int maxlength = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isPalindrome(i, j, str)) {
                    if (j - i + 1 > maxlength) {
                        maxlength = j - i + 1;
                        startPoint = i;
                    }
                }
            }
        }
        String substring = str.substring(startPoint, startPoint + maxlength);
        System.out.println(substring);
        return substring.length();
    }

    public static void main(String[] args) {
            String s="babad";

            System.out.println(longest(s));
        }

}
