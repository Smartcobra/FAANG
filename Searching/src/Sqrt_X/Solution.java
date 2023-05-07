package Sqrt_X;

public class Solution {
    ////https://leetcode.com/problems/sqrtx/
    public int mySqrt(int x) {
        int l = 1;
        int h = x;
        int ans = 0;

        while (l <= h) {
            int mid = (l + h) / 2;

            if (mid <= x / mid) {
                ans = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        return ans;

    }

}
