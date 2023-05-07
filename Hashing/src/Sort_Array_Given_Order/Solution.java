package Sort_Array_Given_Order;

import java.util.*;
//https://www.scaler.com/academy/mentee-dashboard/class/29546/homework/problems/4808?navref=cl_tt_nv
public class Solution {

    public static ArrayList<Integer> solve(List<Integer> A, List<Integer> B) {
        // int idx=0;
        int n = A.size();
        int m = B.size();
        Map<Integer, Integer> map = new TreeMap<>();
        ArrayList<Integer> result = new ArrayList<>();
     //   Collections.sort(A);

        for (int i = 0; i < n; i++) {
            map.put(A.get(i), map.getOrDefault(A.get(i), 0) + 1);
        }

        for (int i = 0; i < m; i++) {
            if (map.containsKey(B.get(i))) {
                for (int j = 0; j < map.get(B.get(i)); j++) {
                    result.add(B.get(i));
                }
            }

            map.remove(B.get(i));
        }

        for (HashMap.Entry<Integer, Integer> mp : map.entrySet()) {
            for (int j = 0; j < mp.getValue(); j++) {
                result.add(mp.getKey());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(20, 14, 8, 18, 6);
        List<Integer> B = Arrays.asList(1, 16, 7, 6, 17, 3, 13, 8, 19, 20);

        System.out.println(solve(A,B));  //6 8 20 14 18

    }
}
