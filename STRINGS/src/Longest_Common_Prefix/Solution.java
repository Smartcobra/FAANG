package Longest_Common_Prefix;

/*
*
* Problem Description

Given the array of strings A, you need to find the longest string S, which is the prefix of ALL the strings in the array.

The longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.

Example: the longest common prefix of "abcdefgh" and "abcefgh" is "abc".
*
*
* Example Input

Input 1:
A = ["abcdefgh", "aefghijk", "abcefgh"]
Input 2:
A = ["abab", "ab", "abcd"];

Example Output
Output 1:
"a"
Output 2:
"ab"
* */
public class Solution {

    public static String solve(String[] str) {
        String shortest = str[0];

        for (int i = 1; i < str.length; i++) {
            if (shortest.length() > str[i].length()) {
                shortest = str[i];
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < shortest.length(); i++) {
            char ch = shortest.charAt(i);
            boolean isFound = true;
            for (String s : str) {
                if (s.charAt(i) != ch) {
                    isFound = false;
                    break;
                }
            }
            if (isFound) {
                ans.append(ch);
            }
        }
        return ans.toString();

    }

    public static void main(String[] args) {
      //  String [] A = {"abcdefgh", "aefghijk", "abcefgh"};

        String [] A ={ "abcd", "aze"};
        System.out.println(solve(A));
    }
}
