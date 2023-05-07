package Median_Two_SortedArray;

import java.util.List;

public class Solution2 {
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {

        int n=a.size();
        int m=b.size();
        if (n > m)
            return findMedianSortedArrays(b, a);

        int l = 0;
        int h = a.size() - 1;
        int te = a.size() + b.size();



        while (l <= h) {
            int aleft = (l + h) / 2;
            int bleft = (te + 1) / 2 - aleft;

            int alM1 = (aleft == 0) ? Integer.MIN_VALUE : a.get(aleft - 1);
            int al = (aleft == a.size()) ? Integer.MAX_VALUE : a.get(aleft);
            int blM1 = (bleft == 0) ? Integer.MIN_VALUE : b.get(bleft - 1);
            int bl = (bleft == b.size()) ? Integer.MAX_VALUE : b.get(bleft);

            if (alM1 <= bl && al >= blM1) {
                double median = 0.0;
                if (te % 2 == 0) {
                    int lmax = Math.max(alM1, blM1);
                    int rmin = Math.min(al, bl);
                    median = (lmax + rmin) / 2.0;
                } else {
                    median = Math.max(alM1, blM1);
                }
               return median;
            } else if (alM1 > bl) {
                h = aleft - 1;

            } else if (blM1 > al) {
                l = aleft + 1;
            }

        }
        return 0.0;
    }
}
