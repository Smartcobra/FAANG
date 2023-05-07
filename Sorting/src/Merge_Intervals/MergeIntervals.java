package Merge_Intervals;

import java.util.ArrayList;
import java.util.Arrays;

///https://leetcode.com/problems/merge-intervals/
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> list = new ArrayList<>();

        for (int[] interval : intervals) {
            if (list.size() == 0) {
                list.add(interval);
            } else {
                int[] prevInteval = list.get(list.size() - 1);
                if (interval[0] <= prevInteval[1]) {
                    prevInteval[1] = Math.max(prevInteval[1], interval[1]);
                } else {
                    list.add(interval);
                }
            }
        }

        return list.toArray(new int[list.size()][]);

    }

}
