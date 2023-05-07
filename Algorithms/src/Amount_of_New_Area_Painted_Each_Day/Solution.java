package Amount_of_New_Area_Painted_Each_Day;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/amount-of-new-area-painted-each-day/
public class Solution {
    public static int[] amountPainted(int[][] paint) {
        Map<Integer, Integer> work = new HashMap<Integer, Integer>();
        int[] painted = new int[paint.length];
        for (int day = 0; day < paint.length; day++) {
            int[] rect = paint[day];
            int start = rect[0];
            int end = rect[1];
            int newArea = 0;
            for (int cord = start; cord < end; cord++) {
                if (!work.containsKey(cord)) {
                    work.put(cord, end);
                    newArea++;
                } else {
                    cord = work.get(cord) - 1;
                }
            }
            painted[day] = newArea;
        }
        return painted;
    }

    public static void main(String[] args) {
        int [][]arr={{1,4},{4,7},{5,8}};
        int[] ints = amountPainted(arr);
        for(int i=0;i<ints.length;i++){
            System.out.println(ints[i]);
        }


    }
}
