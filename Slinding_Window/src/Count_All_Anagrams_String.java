import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
public class Count_All_Anagrams_String {
    public int findAnagrams(String s, String p) {

        int n = s.length();
        int m = p.length();
        int res = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (Character c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = map.size();

        int left = 0;
        int right = 0;
        while (right < n) {

            char rc = s.charAt(right);
            if (map.containsKey(rc)) {
                map.put(rc, map.get(rc) - 1);
                if (map.get(rc) == 0) {
                    count--;
                }
            }

            if (right - left + 1 == m && count == 0) {
                res++;
            }
            if (right - left + 1 > m) {
                char lc = s.charAt(left);
                if (map.containsKey(lc)) {
                    if (map.get(lc) == 0) {
                        count++;
                    }
                    map.put(lc, map.get(lc) + 1);

                }
                left++;

            }

            right++;

        }
        return res;
    }
}
