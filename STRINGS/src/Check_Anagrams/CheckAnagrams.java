package Check_Anagrams;

import java.util.HashMap;
import java.util.Set;

public class CheckAnagrams {
    public boolean isAnagram(String a, String b) {


        if (a.length() != b.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length(); i++) {
            if (map.containsKey(a.charAt(i))) {
                map.put(a.charAt(i),
                        map.get(a.charAt(i)) + 1);
            } else {
                map.put(a.charAt(i), 1);
            }
        }
        // Now loop over String b
        for (int i = 0; i < b.length(); i++) {
            if (map.containsKey(b.charAt(i))) {
                map.put(b.charAt(i),
                        map.get(b.charAt(i)) - 1);
            }
        }
        // Extract all keys of HashMap/map
        Set<Character> keys = map.keySet();
        for (Character key : keys) {
            if (map.get(key) != 0) {
                return false;
            }
        }
        // Returning True as all keys are zero
        return true;
    }
}
