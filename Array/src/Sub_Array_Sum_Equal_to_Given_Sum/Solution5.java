package Sub_Array_Sum_Equal_to_Given_Sum;

import java.util.Arrays;
import java.util.HashMap;

public class Solution5 {
    public static int[] solve(int[] A, int B) {
        int n = A.length;
        long cur_sum = 0;

        HashMap<Long, Integer> map = new HashMap<>();

        int end = 0;
        int i = 0;
        int j = 0;

        while (end < n) {
            cur_sum += A[end];
            if (cur_sum == B) {
                j = end;
                i = 0;
                break;
            }

            long win_Sum = cur_sum - B;
            if (map.containsKey(win_Sum)) {
                i = map.get(win_Sum) + 1;
                j = end;
                break;
            }
            map.put(cur_sum, end);
            end++;
        }

        if (j > 0) {
            int[] result = new int[j - i + 1];
            int k = 0;
            for (int s = i; s <= j; s++) {
                result[k] = A[s];
                ++k;

            }
            return result;
        }
           return new int[]{-1};
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int B = 5;

        System.out.println(Arrays.toString(solve(A, B)));
    }
}
