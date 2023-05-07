package Minimum_Swaps;

import java.util.*;

public class Solution_2 {
    public static int solve(ArrayList<Integer> A) {

        Map<Integer, Integer> map = new HashMap<>();
        int n = A.size();
        int count = 0;
        ArrayList<Integer> tmp = new ArrayList<>(A);

        for (int i = 0; i < n; i++) {
            map.put(A.get(i), i);
        }
        Collections.sort(tmp);

        for (int i = 0; i < n; i++) {
            if (A.get(i) != tmp.get(i)) {
                count++;
                int init = A.get(i);
                swap(A, i, map.get(tmp.get(i)));
                //update map
                map.put(init, map.get(tmp.get(i)));
                map.put(tmp.get(i), i);
            }

        }
        return count;

    }

    public static  void swap(ArrayList<Integer> A, int i, int j) {
        int tmp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, tmp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>(
                Arrays.asList(1, 2, 3, 4, 0));
        // Arrays.asList(1, 12, 10, 3, 14, 10, 5));

        System.out.println(solve(arr));

    }
}
