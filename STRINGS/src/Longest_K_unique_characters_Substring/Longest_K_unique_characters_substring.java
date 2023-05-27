package Longest_K_unique_characters_Substring;

//https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1

import java.util.HashMap;
import java.util.Map;

public class Longest_K_unique_characters_substring {

    public static int getKUniqueSize(String str, int K) {
        int i = 0;
        int j = 0;
        int max = Integer.MIN_VALUE;

        Map<Character, Integer> map = new HashMap<>();

        while (j < str.length()) {
            map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + 1);

            if (map.size() < K) {
                j++;
            } else if (map.size() == K) {
                max = Math.max(max, j - i + 1);
                j++;
            } else {
                while (map.size() > K) {
                    map.put(str.charAt(i), map.get(str.charAt(i)) - 1);

                    if (map.get(str.charAt(i)) == 0) {
                        map.remove(str.charAt(i));
                    }
                    i++;
                }
                j++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String S = "aabacbebebe"; int K = 3;
        System.out.println(getKUniqueSize(S,K));

    }
}
