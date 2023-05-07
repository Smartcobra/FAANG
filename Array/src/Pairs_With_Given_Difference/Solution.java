package Pairs_With_Given_Difference;

import java.util.*;

public class Solution {
    public static int solve(List<Integer> A, int B) {
        int p1 = 0;
        int p2 = 1;
        int n = A.size();
        int count = 0;
        int i = -1;
        int j = -1;
        Collections.sort(A);
        System.out.println(A);

        while (p2 < n) {
            int diff = Math.abs(A.get(p2) - A.get(p1));
            if (diff < B) {
                p2++;
            } else if (diff > B) {
                p1++;
                if (p1 == p2) {
                    p2++;
                }

            } else {
                if (i != A.get(p1) && j != A.get(p2)) {
                    count++;
                    i = A.get(p1);
                    j = A.get(p2);
                }
                p1++;
                p2++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // List<Integer> data = Arrays.asList(1, 5, 3, 4, 2);
        // List<Integer> data = Arrays.asList(8, 12, 16, 4, 0, 20);
        //  int  B = 4;
//        List<Integer> data = Arrays.asList(1, 1, 1, 2, 2);
//        int B = 0;
//        List<Integer> data = Arrays.asList(8, 5, 1, 10, 5, 9, 9, 3, 5, 6, 6, 2, 8, 2, 2, 6, 3, 8, 7, 2,
//                5, 3, 4, 3, 3, 2, 7, 9, 6, 8, 7, 2, 9, 10, 3, 8, 10, 6, 5, 4, 2, 3);
//        int B = 3;
        List<Integer> data = Arrays.asList(1, 2);
        int B = 0;
        System.out.println(solve(data, B));
    }
}
