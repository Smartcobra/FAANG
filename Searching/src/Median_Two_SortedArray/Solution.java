package Median_Two_SortedArray;

public class Solution {

    public static double getMedian(int[] A, int[] B) {

        int l = 0;
        int h = A.length - 1;
        int te = A.length + B.length;
        double median = 0.0;
        while (l <= h) {
            int aleft = (l + h) / 2;
            int bleft = (te + 1) / 2 - aleft;

            int alM1 = (aleft == 0) ? Integer.MIN_VALUE : A[aleft - 1];
            int al = (aleft == A.length) ? Integer.MAX_VALUE : A[aleft];
            int blM1 = (bleft == 0) ? Integer.MIN_VALUE : B[bleft - 1];
            int bl = (bleft == B.length) ? Integer.MAX_VALUE : B[bleft];

            if (alM1 <= bl && al >= blM1) {

                if (te % 2 == 0) {
                    int lmax = Math.max(alM1, blM1);
                    int rmin = Math.min(al, bl);
                    median = (lmax + rmin) / 2.0;
                } else {
                    median = Math.max(alM1, blM1);
                }

            } else if (alM1 > bl) {
                h = aleft - 1;

            } else if (blM1 > al) {
                l = aleft + 1;
            }

        }
        return median;

    }
}
