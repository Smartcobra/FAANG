package minimum_Number_Of_jumps;

import java.util.*;

public class MinJumps_DP_PrintPath {

    public static void print_MinJumps_Path(int arr[]) {
        int n = arr.length;
        int jump[] = new int[n];
        int prev_Index[] = new int[n];
        jump[0] = 0;
        prev_Index[0] = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            jump[i] = min;
            for (int j = 0; j < i; j++) {
                if (i <= j + arr[j] && jump[j] != min) {
                    jump[i] = Math.min(jump[i], jump[j] + 1);
                    prev_Index[i] = j;
                }
            }
        }
        Arrays.stream(jump).forEach(System.out::print);
        System.out.println();
       // System.out.println(jump[n - 1]);
        Arrays.stream(prev_Index).forEach(System.out::print);
        List<Integer> list = new ArrayList<>();
        int ctr = arr.length - 1;
        while (ctr > 0) {
            list.add(ctr);
            ctr = prev_Index[ctr];
        }
        list.add(0);
        Collections.reverse(list);
        Collection<Integer> integers = Collections.unmodifiableCollection(list);
       // integers.stream().forEach(t -> System.out.println(t));
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
        int n = arr.length;
        print_MinJumps_Path(arr);
    }

}
