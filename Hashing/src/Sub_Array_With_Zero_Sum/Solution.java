package Sub_Array_With_Zero_Sum;

import java.util.*;

public class Solution {

    public static int solve(List<Integer> A) {
        int n = A.size();
        Set<Integer> set = new HashSet<>();
        int[] pf_sum = new int[n];
        pf_sum[0] = A.get(0);
        for (int i = 1; i < n; i++) {
            pf_sum[i] = pf_sum[i - 1] + A.get(i);
        }

        for (int i = 0; i < pf_sum.length; i++) {
            set.add(pf_sum[i]);
        }

        if (set.size() != n) return 1;
        if(set.contains(0)) return 1;

        return 0;
    }

    public static void main(String[] args) {
        Integer A[] = new Integer[] {-1,1};
        List<Integer> list = Arrays.asList(A);
        System.out.println(solve(list));
    }
}
