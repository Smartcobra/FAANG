package Points_On_Same_line;

import java.util.ArrayList;
import java.util.HashMap;

///https://www.scaler.com/academy/mentee-dashboard/class/29547/homework/problems/4219?navref=cl_tt_nv


public class PointsOnSameLine {
    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int a = A.size();
        int b = B.size();
        int curr_max = 0;
        int vertical = 0;
        int same = 0;
        int horizontal = 0;

        int maxPoints = 0;
        HashMap<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < a; i++) {
            curr_max = 0;
            vertical = 0;
            same = 0;
            horizontal = 0;

            for (int j = i + 1; j < b; j++) {
                int x1 = A.get(i);
                int y1 = B.get(i);
                int x2 = A.get(j);
                int y2 = B.get(j);
                if (x1 == x2 && y1 == y2) {
                    same++;
                } else if (x1 == x2) {
                    vertical++;
                } else if (y1 == y2) {
                    horizontal++;
                } else {
                    double slope = (double) (y2 - y1) / (x2 - x1);
                    if (!map.containsKey(slope)){
                        map.put(slope, 0);
                    }
                    map.put(slope, map.get(slope) + 1);
                    curr_max = Math.max(curr_max, map.get(slope));
                }
                curr_max = Math.max(curr_max, Math.max(vertical, horizontal));
            }
            maxPoints = Math.max(maxPoints, curr_max + same + 1);
            map.clear();
        }

        return maxPoints;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(3);
        A.add(1);
        A.add(4);
        A.add(5);
        A.add(7);
        A.add(-9);
        A.add(-8);
        A.add(6);

        ArrayList<Integer> B = new ArrayList<>();
        B.add(4);
        B.add(-8);
        B.add(-3);
        B.add(-2);
        B.add(-1);
        B.add(5);
        B.add(7);
        B.add(-4);

//        ArrayList<Integer> A= new ArrayList<>();
//        A.add(6);
//        A.add(-7);
//        A.add(5);
//        A.add(9);
//        A.add(-9);
//        A.add(-7);
//
//        ArrayList<Integer> B= new ArrayList<>();
//        B.add(7);
//        B.add(5);
//        B.add(5);
//        B.add(9);
//        B.add(-8);
//        B.add(2);

        /*
        * A : [ 6, -7, 5, 9, -9, -7 ]
          B : [ 7, 5, 5, 9, -8, 2 ]    //2
* */
        System.out.println(solve(A, B));
    }

}
