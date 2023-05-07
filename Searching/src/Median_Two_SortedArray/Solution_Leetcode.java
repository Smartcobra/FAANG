package Median_Two_SortedArray;

//https://leetcode.com/problems/median-of-two-sorted-arrays/
public class Solution_Leetcode {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        if (n > m) return findMedianSortedArrays(nums2, nums1);

        int l = 0;
        int h = n;
        int total = n + m;

        while (l <= h) {
            int nums1_mid = (l + h) / 2;
            int nums2_mid = (total + 1) / 2 - nums1_mid;
            int nums1_left = nums1_mid - 1;
            int nums2_left = nums2_mid - 1;

            int l1 = (nums1_mid == 0) ? Integer.MIN_VALUE : nums1[nums1_left];
            int r1 = (nums1_mid == n) ? Integer.MAX_VALUE : nums1[nums1_mid];
            int l2 = (nums2_mid == 0) ? Integer.MIN_VALUE : nums2[nums2_left];
            int r2 = (nums2_mid == m) ? Integer.MAX_VALUE : nums2[nums2_mid];

            if (l1 < r2 && l2 < r1) {
                double median = 0.0;
                if (total % 2 == 0) {
                    int lmax = Math.max(l1, l2);
                    int rmin = Math.min(r1, r2);
                    median = (lmax + rmin) / 2.0;
                } else {
                    median = Math.max(l1, l2);
                }

                return median;
            } else if (l1 > r2) {
                h = nums1_mid - 1;

            } else if (l2 > r1) {
                l = nums1_mid + 1;
            }
        }
        return 0.0;

    }
}
