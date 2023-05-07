package Pick_from_BothSide;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Solution2 {
    public static int solve(int[] A, int B) {

        int n = A.length;
        int[] pf = new int[n];
        int[] sf = new int[n];

        pf[0] = A[0];
        sf[n - 1] = A[n - 1];

        for (int i = 1; i < n; i++) {
            pf[i] = pf[i - 1] + A[i];
        }

        for (int i = n - 2; i >= 0; i--) {
            sf[i] = sf[i + 1] + A[i];
        }

        int ans = sf[n - B];
        int sum = 0;
        for (int i = 1; i <= B; i++) {
            if (i == B) {
                sum = pf[i - 1];
            } else {
                sum = pf[i - 1] + sf[n - B + i];
            }
            ans = Math.max(ans, sum);
        }
        return ans;

    }


    public static void main(String[] args) {
        int[] a = {5, -2, 3, 1, 2};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            list.add(a[i]);
        }

        int B = 3;

        System.out.println(solve(a, B));
    }
}
