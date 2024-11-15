///https://leetcode.com/problems/minimum-window-substring/

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        int n = s.length();
        int reqCont = t.length();
        int minLength = Integer.MAX_VALUE;
        int start_left = 0;


        Map<Character, Integer> map = t.chars().mapToObj(c -> (char) c)
                .collect(Collectors.toMap(Function.identity(), v -> 1, Integer::sum));


        int left = 0;
        int right = 0;
        while (right < n) {
            char rc = s.charAt(right);
            if (map.containsKey(rc)) {
                if (map.get(rc) > 0) {
                    reqCont--;
                }
                map.put(rc, map.get(rc) - 1);

            }

            while (reqCont == 0) {
                char lc = s.charAt(left);
                if (map.containsKey(lc)) {
                    map.put(lc, map.get(lc) + 1);
                    if (map.get(lc) >= 1) {
                        reqCont++;
                    }
                }
                if (minLength > right - left+1) {
                    minLength = right - left+1;
                    start_left = left;
                }
                left++;
            }

            right++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start_left, start_left + minLength);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));

    }
}
