package Meeting_Rooms_II;

import java.util.Arrays;

public class MeetingRooms_II {
    public static int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int room = 0;

        int[] startArr = new int[n];
        int[] endArr = new int[n];



        for (int i = 0; i < n; i++) {
            startArr[i] = intervals[i][0];
            endArr[i] = intervals[i][1];
        }
        Arrays.sort(startArr);
        Arrays.sort(endArr);

        int i = 0;
        int j = 0;

        while (i < n) {
            if (startArr[i] < endArr[j]) {
                room++;
                i++;
            } else {
                i++;
                j++;
            }
        }

        return room;

    }

    public static void main(String[] args) {
//        int[][] arr= {{5,8},{6,8}};
//        System.out.println(minMeetingRooms(arr));
//
        int[][] arr = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(minMeetingRooms(arr));
//
//        int [][] arr={{9,10},{4,9},{4,17}};
//        System.out.println(minMeetingRooms(arr));


    }
}
