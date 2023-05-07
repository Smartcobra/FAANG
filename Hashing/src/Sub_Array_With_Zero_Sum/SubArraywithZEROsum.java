package Sub_Array_With_Zero_Sum;

import java.util.*;

public class SubArraywithZEROsum {
    public static int solve(int[] arr) {
        long[] ps = new long[arr.length];
        ps[0] = arr[0];
        Set<Long> set = new HashSet<>();
        set.add(ps[0]);

        for (int i = 1; i < arr.length; i++) {
            ps[i] = ps[i - 1] + arr[i];  // if subarray sum will zero ,inserted into set
            if (set.contains(ps[i]) || ps[i] == 0) {
                return 1;
            } else {
                set.add(ps[i]);
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        int[] arr = {96, -71, 18, 66, -39, -32, -16, -83, -11, -92, 55, 66, 93, 5, 50, -45, 66, -28, 69, -4, -34, -87, -32, 7, -53, 33, -12, -94, -80, -71, 48, -93, 62};
        int solve = solve(arr);
        System.out.println(solve);


    }
}
