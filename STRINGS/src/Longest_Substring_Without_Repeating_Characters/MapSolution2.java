package Longest_Substring_Without_Repeating_Characters;

import java.util.HashMap;
import java.util.Map;

public class MapSolution2 {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
              //  j = i + 1;
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    public static void main(String[] args) {
       String s = "abcabcbb";
//        System.out.println(lengthOfLongestSubstring(s));
       // String s = "pwwwkew";
        System.out.println(lengthOfLongestSubstring(s));


    }
}
