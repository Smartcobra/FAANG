package Sliding_Window_Maximum;

import java.util.*;

public class SlidingWindowMaximum {

    public static  ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        Deque<Integer> deq = new LinkedList<>();
        int n=A.size();
        int l = 1;
        int r = B;
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < B; i++) {
            while (!deq.isEmpty() && deq.getLast() <= A.get(i)) {
                deq.removeLast();
            }
            deq.offerLast(A.get(i));
        }
        ans.add(deq.getFirst());

        while (r < n) {
            if (!deq.isEmpty() && deq.getFirst() == A.get(l - 1)) {
                deq.removeFirst();
            }

            while (!deq.isEmpty() && deq.getLast() <= A.get(r)) {
                deq.removeLast();
            }

            deq.offerLast(A.get(r));
            ans.add(deq.getFirst());

            l++;
            r++;

        }
        return ans;
    }

    public static void main(String[] args) {
      //  List<Integer> arr = Arrays.asList(8, 5, 10, 7, 9, 4, 15, 12, 90, 13);
        List<Integer> arr = Arrays.asList(2, 5, -1, 7, -3, -1, -2);
        System.out.println(slidingMaximum(arr,4));
    }
}
