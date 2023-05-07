package Count_of_divisors;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static int[] solve(int[] A) {
        int n = A.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int tmp = countDivisor(A[i]);
            result[i] = tmp;
        }

        return result;
    }


    public static int countDivisor(int A) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= A; i++) {
            if (A % i == 0) {
                if (A / i == i) {
                    list.add(i);
                    System.out.println(i);
                } else {
                    list.add(i);
                    list.add(A / i);

                    System.out.println(i +""+A/i);
                }
            }

        }

        return list.size();
    }

    public static void main(String[] args) {
        int[] A = {2, 3, 4, 5};
        System.out.println(Arrays.toString(solve(A))); ///2 2 3 2

    }
}
