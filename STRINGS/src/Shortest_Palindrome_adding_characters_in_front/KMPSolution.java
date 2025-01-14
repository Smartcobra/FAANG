package Shortest_Palindrome_adding_characters_in_front;

public class KMPSolution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;

        String reversed = new StringBuilder(s).reverse().toString();
        String combined = s + '#' + reversed;
        int[] lps = computeLps(combined);

        int palidromicPfxLen = lps[combined.length() - 1];

        String prefixToAdd = reversed.substring(0, s.length() - palidromicPfxLen);
        return prefixToAdd + s;
    }

    private int[] computeLps(String s) {
        int length = s.length();
        int[] lps = new int[length];
        int len = 0;
        int i = 1;

        while (i < length) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}
