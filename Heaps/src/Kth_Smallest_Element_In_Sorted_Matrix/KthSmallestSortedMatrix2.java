package Kth_Smallest_Element_In_Sorted_Matrix;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


public class KthSmallestSortedMatrix2 {
    public static int solve(ArrayList<ArrayList<Integer>> A, int B) {
        int n = A.size();
        int m = A.get(0).size();
        PriorityQueue<HeapNode> pq = new PriorityQueue<>(Math.min(B, n), Comparator.comparingInt(o -> o.val));

        for (int i = 0; i < Math.min(n, B); i++) {
            pq.offer(new HeapNode(i, 0, A.get(i).get(0)));
        }

        HeapNode ele = pq.peek();
        while (B-- > 0) {
            ele = pq.poll();
            int r = ele.row;
            int c = ele.col;
            if (c < m - 1) {
                pq.offer(new HeapNode(r, c + 1, A.get(r).get(c + 1)));
            }
        }


        return ele.val;
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(5);
        l1.add(9);
        l1.add(11);
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(9);
        l2.add(11);
        l2.add(13);
        ArrayList<Integer> l3 = new ArrayList<>();
        l3.add(10);
        l3.add(12);
        l3.add(15);
        ArrayList<Integer> l4 = new ArrayList<>();
        l4.add(13);
        l4.add(14);
        l4.add(16);
        ArrayList<Integer> l5 = new ArrayList<>();
        l5.add(16);
        l5.add(20);
        l5.add(21);
        input.add(l1);
        input.add(l2);
        input.add(l3);
        input.add(l4);
        input.add(l5);

        System.out.println(solve(input, 12));
    }
}

