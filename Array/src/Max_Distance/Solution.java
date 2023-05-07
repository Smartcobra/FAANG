package Max_Distance;

import java.util.List;

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maximumGap(final List<Integer> A) {
        int n = A.size();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A.get(i) <= A.get(j)) {
                    max = Math.max(max, j - i);
                }
            }
        }

        return max;
    }


}
