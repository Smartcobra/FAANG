package Permutation_In_String_567;
//https://leetcode.com/problems/permutation-in-string/
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if (n > m) return false;

        int[] f1 = new int[26];
        int[] f2 = new int[26];

        for (char c : s1.toCharArray()) {
            f1[c - 'a']++;
        }
        int i = 0;
        int j = 0;

        while (j < m) {
            f2[s2.charAt(j) - 'a']++;

            if (j - i + 1 > n) {
                f2[s2.charAt(i) - 'a']--;
                i++;
            }

            if (matches(f1, f2)) {
                return true;
            }
            j++;
        }

        return false;


    }

    private boolean matches(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) return false;
        }

        return true;
    }
}