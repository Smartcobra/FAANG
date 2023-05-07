package First_Non_Repeating_Character;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingChar {
    public static String solve(String A) {
        int len = A.length();
        StringBuilder ans = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            char c = A.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            q.add(c);

            while (!q.isEmpty() && map.get(q.peek()) > 1) {
                q.remove();
            }
            if (!q.isEmpty()) {
                ans.append(q.peek());
            } else {
                ans.append("#");
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(solve("gu"));
    }
}
