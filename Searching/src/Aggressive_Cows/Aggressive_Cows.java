package Aggressive_Cows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Aggressive_Cows {
    public static int solve(List<Integer> A, int cows) {
        int n = A.size();
        int ans = 0;
        Collections.sort(A);
        int l = Integer.MAX_VALUE;
        int h = A.get(n - 1) - A.get(0);
        for (int i = 1; i < n; i++) {
            l = Math.min(l, A.get(i) - A.get(i - 1));
        }

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (isPossible(mid, A, cows)) {
                ans = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        return ans;
    }

    public static boolean isPossible(int distance, List<Integer> A, int cows) {
        int count = 1;
        int lastCowPosition = A.get(0);

        for (Integer currPosition : A) {
            if (currPosition - lastCowPosition >= distance) {
                count++;
                lastCowPosition = currPosition;
                ////once you replace all the cow no need to go further
                if (count == cows) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(82, 61, 38, 88, 12, 7, 6, 12, 48, 8, 31, 90, 35, 5, 88, 2, 66, 19, 5, 96, 84, 95 );
        System.out.println(solve(A, 8));
    }
}
