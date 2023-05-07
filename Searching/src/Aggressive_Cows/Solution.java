package Aggressive_Cows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/////https://www.scaler.com/academy/mentee-dashboard/class/29544/assignment/problems/4129
public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;
        int l = Integer.MAX_VALUE;
        Arrays.sort(A);
        for (int i = 1; i < n; i++) {
            l = Math.min(l, A[i] - A[i - 1]);
        }
        int r = A[n - 1] - A[0];
        int ans = 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(mid, A, B)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public boolean check(int distance, int[] A, int cows) {
        int count = 1;
        int lastcow = A[0];

        for (int i = 1; i < A.length; i++) {
            if (A[i] - lastcow >= distance) {
                lastcow = A[i];
                count++;
                if (count == cows) return true;
            }
        }
        return false;
    }

}
