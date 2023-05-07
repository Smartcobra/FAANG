package Product_of_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Product_of_3 {
    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < n; i++) {
            maxHeap.add(A.get(i));
            if (i < 2) {
                result.add(-1);
            } else {
                int max1 = maxHeap.poll();
                int max2 = maxHeap.poll();
                int max3 = maxHeap.poll();
                result.add(max1 * max2 * max3);
                maxHeap.add(max1);
                maxHeap.add(max2);
                maxHeap.add(max3);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(solve(list));
    }
}
