package Matrix_Median;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {

    public static int findMedian(List<List<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (List<Integer> ints : A) {
            low = Math.min(low, ints.get(0));
            high = Math.max(high, ints.get(m - 1));
        }

        while (low <= high) {
            int mid = (low + high) >> 1;
            int count = 0;
            for (List<Integer> integers : A) {
                count = count + countSmallerThanMid(integers, mid, m);
            }

            if (count <= (n * m) / 2) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    public static int countSmallerThanMid(List<Integer> A, int mid, int col) {
        int low = 0;
        int high = col - 1;

        while (low <= high) {
            int md = (low + high) >> 1;

            if (A.get(md) <= mid) {
                low = md + 1;
            } else {
                high = md - 1;
            }
        }

        return low;

    }


    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 3, 5);
        List<Integer> list2 = Arrays.asList(2, 3, 4);
        List<Integer> list3 = Arrays.asList(1, 7, 9);
        List<List<Integer>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);

        System.out.println(findMedian(list));
    }
}
