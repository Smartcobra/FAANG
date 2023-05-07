import java.util.HashMap;
import java.util.Map;

public class TestTest {

    public static int lengthOfLongestSubstring(String str) {
        int n = str.length();
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int i = 0;
        int j = 0;
        ;


        while (j < n) {
            map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + 1);

            if (map.size() == j - i + 1) {
                result = Math.max(result, j - i + 1);
                j++;
            } else if (map.size() < j - i + 1) {

                while (map.size() < j - i + 1) {
                    map.put(str.charAt(i), map.get(str.charAt(i)) - 1);

                    if (map.get(str.charAt(i)) == 0) {
                        map.remove(str.charAt(i));
                    }
                    i++;
                }

            }

            //j++;
        }

        return result;
    }

    public static void main(String[] args) {
        String str="abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }

}
