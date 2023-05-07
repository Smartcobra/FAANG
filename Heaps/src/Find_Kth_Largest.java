import java.util.List;
import java.util.PriorityQueue;

public class Find_Kth_Largest {

    //Using Max Heap
    public int getKthLargest_MaxHeap(List<Integer> ints, int k) {

        if (ints == null || ints.size() < k) {
            System.exit(-1);
        }

        // create maxHeap
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        q.addAll(ints);

        while (--k > 0) {
            q.poll();
        }

        return q.peek();

    }

    ///////Using Mean Heap
    public int getKthLargest_MeanHeap(List<Integer> ints, int k) {

        if (ints == null || ints.size() < k) {
            System.exit(-1);
        }

        // create maxHeap
        PriorityQueue<Integer> q = new PriorityQueue<>(ints.subList(0, k));

        ///do for remaining element
        for (int i = k; i < ints.size(); i++) {
            //// if the current element is more than the root of the heap
            if (ints.get(i) > q.peek()) {
                //remove root
                q.poll();
                q.add(ints.get(i));
            }

        }
        return q.peek();

    }

    public static void main(String[] args) {

    }
}


