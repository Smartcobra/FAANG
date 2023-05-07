package No_Of_Distinct_Elemnts;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution3_GetorDefault {
    public static ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < B; i++) {
                map.put(A.get(i), map.getOrDefault(A.get(i), 0) + 1);
        }
            result.add(map.size());

            ///2nd part
            for (int i = 1, j = B; i <= A.size() - B; i++, j++) {
                map.put(A.get(i - 1), map.get(A.get(i - 1))-1);
                if (map.get(A.get(i - 1)) == 0) {
                    map.remove(A.get(i - 1));
                }

                    map.put(A.get(j),map.getOrDefault(A.get(j),0)+1);

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
