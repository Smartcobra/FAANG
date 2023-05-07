package N_Integers_Containing_Only_1_2_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static int solve(int A) {
        Queue<Integer> queue = new LinkedList<>();
      //  ArrayList<Integer> result = new ArrayList<>();
        int count = 3;
        int removalCount = 0;
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        while (count < A) {
            String x = String.valueOf(queue.peek());
            queue.remove();
            removalCount++;
            queue.offer(Integer.valueOf(x + "1"));
            queue.offer(Integer.valueOf(x + "2"));
            queue.offer(Integer.valueOf(x + "3"));
            count = count + 3;

        }
        int tmp = A - removalCount;
        int result=0;
        while (tmp > 0) {
           result=queue.peek();
            queue.remove();
            tmp--;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solve(7));
    }
}
