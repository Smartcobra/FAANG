import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Find_Kth_Smallest {
    public static int getKthSmallest(List<Integer> input, int k) {

        if (input == null || input.size() < k) {
            System.exit(-1);
        }

        PriorityQueue<Integer> q = new PriorityQueue(input);

        while (--k > 0) {
            q.poll();
        }
        return q.peek();

    }
    // Function to find the k'th smallest element in an array using max-heap
    public static int findKthSmallest(List<Integer> input, int k)
    {
        // base case
        if (input == null || input.size() < k) {
            System.exit(-1);
        }

        // create a max-heap using the `PriorityQueue` class and
        // insert the first `k` array elements into the heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.addAll(input.subList(0, k));

        // do for remaining array elements
        for (int i = k; i < input.size(); i++)
        {
            // if the current element is less than the root of the heap
            if (input.get(i) < pq.peek())
            {
                // replace root with the current element
                pq.poll();
                pq.add(input.get(i));
            }
        }

        // return the root of max-heap
        return pq.peek();
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(7, 4, 6, 3, 9, 1);
        int k = 3;
        System.out.println(getKthSmallest(input,3));

    }
}
