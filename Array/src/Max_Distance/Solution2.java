package Max_Distance;

import javafx.print.Collation;

import java.util.*;

/////nlogn   using sorting and hasmap
public class Solution2 {
    public static int maximumGap(final List<Integer> A) {
        int n = A.size();
        int maxDiff = Integer.MIN_VALUE;
        int min_i = Integer.MAX_VALUE;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();


        for (int i = 0; i < n; i++) {
            if (map.containsKey(A.get(i))) {
                map.get(A.get(i)).add(i);
            } else {
                map.put(A.get(i), new ArrayList<Integer>());
                map.get(A.get(i)).add(i);
            }
        }
        Collections.sort(A);
        if(map.size()==1){
            return n-1;
        }

        // Iterate from 0 to n - 1
        for (int i = 0; i < n; i++) {
           min_i= Math.min(min_i,map.get(A.get(i)).get(0));  // minimize the i
           maxDiff=Math.max(maxDiff,map.get(A.get(i)).get(0)-min_i);
        }
        return maxDiff;

    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>(
               // Arrays.asList(34, 8, 10, 3, 2, 80, 30, 33, 1));
                Arrays.asList(100, 100, 100, 100, 100));
        System.out.println(maximumGap(arr));

    }
}
