package Longest_Substring_With_At_Least_K_Repeating_Characters;

import java.util.HashMap;

public class Solution {
    public static int longestSubstring(String s, int k) {
        //Base Conditions

        //if string length is less than k or string length is 0
        if (s.length() < k || s.length() == 0) return 0;
        //if k is 0 or 1 so return whole string length
        if (k <= 1) return s.length();
        // ------------------------------------------------------------------------------------------------------------------------

        //small Calculations

        //to store the frequency of string characters
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        //to count till which we find that char whose frequency is less than k
        int l = 0;
        for (int i = 0; i < s.length() && map.get(s.charAt(i)) >= k; i++) {
            l++;
        }
        //if we reached at last index of string or l is equal to length than return the l
        if (l >= s.length() - 1) return l;

      //  ------------------------------------------------------------------------------------------------------------------------
        //Recursive calls

        //if we find that char whose frequency is less than k then divide the strings into two halves
        //and call the recursion individually
        int l1 = longestSubstring(s.substring(0, l), k);
        //to optimize the problem find the index till which that char whose frequency is less than k lies
        //for eg.. string = aaallbbb , k=3
        // if we reached third index than instead dividing into substr(0,l) & substr(l) we find till which that char whose           //freq less than k lies
        //and did substr(0,l) and then while and then substr(l).. where l==5;
        while (l < s.length() && map.get(s.charAt(l)) < k) l++;
        int l2 = longestSubstring(s.substring(l), k);

     //   -------------------------------------------------------------------------------------------------------------------------
        //at last returned the longest substring length which recursion brings to us
        return Math.max(l1, l2);

    }

    public static void main(String[] args) {
        String s = "abcabcccbb";
        int k = 3;
        int result = longestSubstring(s, k);
        System.out.println("The longest substring with at least " + k + " repeating characters is " + result + " characters long.");
    }
}
