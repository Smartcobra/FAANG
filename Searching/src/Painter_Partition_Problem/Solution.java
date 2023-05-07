package Painter_Partition_Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution {
    public static int paint(int A, int B, List<Integer> C) {
        int n = C.size();
        int ans = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (Integer i : C) {
            max = Math.max(max, i);
        }
        System.out.println(max);
        for (Integer i : C) {
            sum += i;
        }
        System.out.println(sum);
        int high = sum * B;
        int low = max * B;

        while (low <= high) {
            int time = (low + high) / 2; //mid

            if (check(time, C, A)) {
                ans = time;
                high = time - 1;
            } else {
                low = time + 1;
            }
        }
        return ans;
    }

    private static boolean check(int time, List<Integer> C, int A) {
        int s = 0;
        int count = 0;
        for (Integer integer : C) {
            s = s + integer;
            if (s > time) {
                s = integer;
                count++;
            }

        }
        if (s != 0) count++;
        return count <= A;
    }

    public static void main(String[] args) {
        int A = 3;
        int B = 10;

        List<Integer> C = Arrays.asList(185, 186, 938, 558, 655, 461, 441, 234, 902, 681);
        System.out.println(paint(A, B, C));
    }
}
