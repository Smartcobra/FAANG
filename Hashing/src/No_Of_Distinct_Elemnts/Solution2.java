package No_Of_Distinct_Elemnts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution2 {
    public static  ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < B; i++) {
            if (map.containsKey(A.get(i))) {
                int val = map.get(A.get(i));
                map.put(A.get(i), val + 1);
            } else {
                map.put(A.get(i), 1);
            }
        }
        result.add(map.size());

        ///2nd part
        for (int i = 1, j = B; i <= A.size() - B; i++, j++) {
            int val = map.get(A.get(i - 1));
            map.put(A.get(i-1), val - 1);
            if (map.get(A.get(i - 1)) == 0) {
                map.remove(A.get(i - 1));
            }

            if (map.containsKey(A.get(j))) {
                int val1 = map.get(A.get(j));
                map.put(A.get(j), val1 + 1);
            } else {
                map.put(A.get(j), 1);
            }

            result.add(map.size());
        }

        return result;
    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(3);
        int k=3;
        ArrayList<Integer> integers = dNums(list, k);
        integers.forEach(System.out::println);

    }
}
