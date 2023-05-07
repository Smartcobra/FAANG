package Meeting_Rooms;

import java.util.Arrays;

public class MeetingRooms {

    public boolean canAttendMeetings(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < n; i++) {
            if (intervals[i][1] > intervals[i + 1][n]) {
                return false;
            }

        }
        return true;
    }
}
