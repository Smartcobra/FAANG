package Maximum_Array_Sum_After_B_Negations;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumArraySumAfterBNegations {

    public static int solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(A);
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        while (B-- > 0) {
            int val = minHeap.poll();
            val = -1 * val;
            minHeap.add(val);
        }
        while (!minHeap.isEmpty()) {
            sum = sum + minHeap.poll();
        }

        return sum;
    }

    public int solve(int[] A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int x : A) pq.add(x);

        while (B > 0) {
            // pop minimum lement from the queue
            int x = pq.poll();
            // if minimum element is 0, we will use all remaining opeations on this and the result will be same
            if (x == 0) {
                B = 0;
            }
            // if minimum element is negative, modify the element to -x and push -x to queue.
            else if (x < 0) {
                pq.add(-x);
            } else {
                //if remaining operations are even, then in one operation we convert x to -x and in another -x to x. So, no change
                //if operations are odd, we will change the number to -x. Set B = 0.
                if (B % 2 == 0) {
                    pq.add(x);
                } else {
                    pq.add(-x);
                }
                break;
            }

            B--;
        }

        int ans = 0;

        // add all the elements in the queue to the answer
        while (pq.size() > 0) {
            ans += pq.poll();
        }

        return ans;
    }


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(24);
        list.add(-68);
        list.add(-29);
        list.add(-9);
        list.add(84);
        System.out.println(solve(list, 4));

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(57);
        list2.add(3);
        list2.add(-14);
        list2.add(-87);
        list2.add(42);
        list2.add(38);
        list2.add(31);
        list2.add(-7);
        list2.add(-28);
        list2.add(-61);
        System.out.println(solve(list2, 10));

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(-18);
        list3.add(-79);
        list3.add(-54);
        list3.add(-12);
        list3.add(77);
        list3.add(-73);
        list3.add(-27);
        list3.add(-46);
        list3.add(-8);
        System.out.println(solve(list3, 9));

        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(-43);
        list4.add(-1);
        list4.add(-19);
        list4.add(87);
        list4.add(-45);
        System.out.println(solve(list4, 5));


    }
}
