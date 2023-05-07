package N_Integers_Containing_Only_1_2_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//https://www.scaler.com/academy/mentee-dashboard/class/35015/homework/problems/4364?navref=cl_tt_lst_nm
public class Solution_Scalar {
    public static ArrayList<Integer> solve(int A) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int count = 3;
      //  int removalCount = 0;
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        result.add(1);
        result.add(2);
        result.add(3);

//        while (count <= A) {
//            String x = String.valueOf(queue.poll());
//            queue.offer(Integer.valueOf(x + "1"));
//            queue.offer(Integer.valueOf(x + "2"));
//            queue.offer(Integer.valueOf(x + "3"));
//            result.add(Integer.valueOf(x + "1"));
//            result.add(Integer.valueOf(x + "2"));
//            result.add(Integer.valueOf(x + "3"));
//            count = count + 3;
//
//        }
        while (count <= A) {
            int x = queue.poll();
            x=x*10;
            queue.offer(x+1);
            queue.offer(x+2);
            queue.offer(x+3);
            result.add(x+1);
            result.add(x+2);
            result.add(x+3);
            count = count + 3;

        }
        return new ArrayList<>(result.subList(0,A));
    }

    public static void main(String[] args) {
        System.out.println(solve(7));
    }
}
