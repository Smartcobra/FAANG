package SubArrayLength;

import java.util.Arrays;

public class PrintSubArrayPositive {
    public  static int[] solve(int[] A) {
        int n = A.length;

        int i = 0;
        int j = 0;

        int start = 0;
        int end = 0;

        while (i < n && j < n) {
            if (A[j] < 0) {
                if (j - i > end - start) {
                    start = i;
                    end = j - 1;
                }
                i = j + 1;
            }
            j++;
        }

        int[] result = new int[end - start + 1];
        int m = 0;
        for (int k = start; k <= end; k++) {
            result[m] = A[k];
            m++;
        }

        return result;
    }



    public static void main(String[] args) {
        //int [] A={8986143, -5026827, 5591744, 4058312, 2210051, 5680315, -5251946, -607433, 1633303, 2186575};
       int [] A={-4549634, -3196682, 8455838, -1432628, -263819, -3928366, -5556259, -2114783, 3923939, -4183708};
        //5591744 4058312 2210051 5680315
        int[] solve = solve(A);
        Arrays.stream(solve).forEach(System.out::println);
       // System.out.println(solve(A));

    }
}
