package Insert_Intervals;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> res = new ArrayList<>();
        // Iterate through the intervals array
        for (int[] interval : intervals) {
            // If the current interval is completely after the new interval, add the new interval and the current interval to the result list
            if (interval[0] > newInterval[1]) {
                res.add(newInterval);
                newInterval = interval;
            } else if (interval[1] < newInterval[0]) {
                res.add(interval);
                // If the current interval and the new interval overlap, merge them and update the new interval
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        // Add the last new interval to the result list
        res.add(newInterval);
        // Return the result list as an array
        return res.toArray(new int[res.size()][]);

    }
}
