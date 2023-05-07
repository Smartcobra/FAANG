package Minimum_Swaps_Sort_Array;

import javafx.util.Pair;

import java.util.*;

public class Solution_Hashmap {

    public static int solve(ArrayList<Integer> A) {

        ArrayList<Map<Integer,Integer>> list = new ArrayList<>();
        int n = A.size();
        int count = 0;
        ArrayList<Integer> tmp=A;

        for (int i = 0; i < n; i++) {
            Map<Integer,Integer> map=new HashMap<>();
            map.put(A.get(i),i);
            list.add(map);
        }
//        Collections.sort(list, new Comparator<Map<Integer, Integer>>() {
//            @Override
//            public int compare(Map<Integer, Integer> o1, Map<Integer, Integer> o2) {
//                for(Map.Entry<Integer,Integer> m1:o1.entrySet()){
//
//                }
//            }
//        });

        for (int i = 0; i < n; i++) {
            //System.out.println(A.get(i));
           // System.out.println(list.get(0).get(1));
            if (list.get(i).get(A.get(i)) == i) {
                continue;
            } else {
                count++;
                swap(list.get(i), list.get(list.get(i).get(A.get(i))));
                i--;
            }

        }
        return count;

    }

    public static void swap(Map<Integer,Integer> map1, Map<Integer,Integer> map2) {
        Map<Integer,Integer>  t = map1;
        map1 = map2;
        map2 = t;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>(
                Arrays.asList(1, 2, 3, 4, 0));
        // Arrays.asList(1, 12, 10, 3, 14, 10, 5));

         System.out.println(solve(arr));

    }
}
