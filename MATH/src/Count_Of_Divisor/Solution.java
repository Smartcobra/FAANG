package Count_Of_Divisor;

import java.util.ArrayList;
import java.util.Arrays;


////////////////It will give TLE
public class Solution {

    public static int[] solve(int[] A) {
        int n = A.length;
        int[] result = new int[n];


        for (int i = 0; i < n; i++) {
            //  int i = 0;
            if (A[i] == 1) {
                result[i] = 1;
            }
            int N = A[i];
            int total = 1;
            while (N > 1) {
                int p = findSmallestPrimeFactor(N);
                // System.out.println(p);
                int c = 0;
                while (N % p == 0) {
                    c++;
                    N = N / p;
                }
                total = total * (c + 1);
                result[i] = total;
            }
            //  System.out.println(total);
        }


        return result;
    }

    public static int findSmallestPrimeFactor(int N) {
        // if divisible by 2
        if (N % 2 == 0)
            return 2;

        // iterate from 3 to sqrt(n)
        for (int i = 3; i * i <= N; i += 2) {
            if (N % i == 0)
                return i;
        }
        // System.out.println(N);
        return N;

    }

    public static void main(String[] args) {
        // int[] A = {2, 3, 4, 5};
        //  int[] A = {10, 20};
        int[] A = {3, 52, 66, 64, 14, 51, 6, 39, 5, 26, 80, 88, 60, 73, 67, 16, 1, 81, 62, 42, 83, 31, 40, 4, 32, 31, 44, 3, 20, 94, 93, 57, 2, 18, 32, 59, 91, 30, 45};
        // System.out.println(findSmallestPrimeFactor(10));
        System.out.println(Arrays.toString(solve(A)));
    }
}
