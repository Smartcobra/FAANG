package Roman_To_Integer;

import java.util.HashMap;
import java.util.Map;

public class Roman_to_Integer {
    public int romanToInt(String s) {
        int n = s.length();

        Map<Character, Integer> values = new HashMap<>();
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);

        int lastVal = values.get(s.charAt(n - 1));
        int result = lastVal;

        for (int i = n - 2; i >= 0; i--) {
            int curval = values.get(s.charAt(i));
            if (lastVal > curval) {
                result -= curval;
            } else {
                result += curval;
            }
            lastVal = curval;
        }

        return result;


    }
}
