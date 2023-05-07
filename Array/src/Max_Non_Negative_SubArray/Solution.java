package Max_Non_Negative_SubArray;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int start = 0;
        int end = 0;
        int s = 0;
        int max_cur = 0;
        int max_so_far = 0;

        int n = A.size();

        for (int i = 0; i < n; i++) {
            if (A.get(i) < 0) {
                s = i + 1;
                max_cur = 0;
            } else {
                max_cur += A.get(i);
            }

            if (max_cur > max_so_far) {
                max_so_far = max_cur;
                start = s;
                end = i;
            }

        }
        for (int i = start; i <= end; i++) {
            result.add(A.get(i));
        }
        return result;
    }
}
