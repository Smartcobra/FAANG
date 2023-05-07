package Painter_Partition_Problem;

import java.util.ArrayList;

public class Solution2 {
    public int paint(int A, int B, ArrayList<Integer> C) {
        int MOD = 10000003;
        int n = C.size();

        int max = Integer.MIN_VALUE;
        long sum = 0;
        for (Integer i : C) {
            max = Math.max(max, i);
        }
        // System.out.println(max);
        for (Integer i : C) {
            sum += i;
        }
        // System.out.println(sum);
        long high = sum;
        long low = max;
        long ans = high;

        while (low <= high) {
            long time = (low + high) / 2; //mid

            if (canDo(time, C, A)) {
                ans = time;
                high = time - 1;
            } else {
                low = time + 1;
            }
        }
        return (int) ((ans * B) % MOD);

    }

    public boolean canDo(long time, ArrayList<Integer> C, int noWorkers) {
        long s = 0;
        int count = 0;

        for (Integer integer : C) {
            s += integer;
            if (s > time) {
                s = integer;
                count++;
            }
        }
         if (s != 0) count++;
        return count <= noWorkers;
    }
}
