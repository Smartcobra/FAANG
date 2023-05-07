package Sub_Array_Sum_Equal_to_Given_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3 {
    public static  ArrayList<Integer> solve(ArrayList<Integer> A, int B) {

        int start = 0;
        int end = 0;
        int window_sum = 0;
        ArrayList<Integer> result = new ArrayList<>();

        while (end < A.size()) {
            window_sum += A.get(end);

            if (window_sum == B) {
                for (int i = start; i <= end; i++) {
                    result.add(A.get(i));
                }
                return result;
            }
            while (window_sum > B && start <= end) {
                window_sum = window_sum - A.get(start++);
                if (window_sum == B) {
                    for (int i = start; i <= end; i++) {
                        result.add(A.get(i));
                    }
                    return result;
                }
            }
            end++;
        }
        result.add(-1);
        return result;

    }

    public static void main(String[] args) {

        ArrayList<Integer> list= new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        int B = 5;
        ArrayList<Integer> solve = solve(list, B);
        solve.stream().forEach(System.out::print);
    }
}
