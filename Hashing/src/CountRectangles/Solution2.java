package CountRectangles;
///https://www.scaler.com/academy/mentee-dashboard/class/29547/assignment/problems/4759?navref=cl_tt_nv
import javafx.util.Pair;

import java.io.Serializable;
import java.util.*;

class Pairs<K,V>  {
    private K key;
    private V value;

    Pairs(K x, V y) {
        this.key= x;
        this.value = y;
    }

    public K getKey(){
        return key;
    }

    public V getValue(){
        return value;
    }
}

public class Solution2 {
    public static int solve(List<Integer> A, List<Integer> B) {
        int n = A.size();
        int count = 0;

        Set<Pairs<Integer, Integer>> pairs = new TreeSet<>((o1, o2) -> {
            int x1 = o1.getKey();
            int y1 = o1.getValue();
            int x2 = o2.getKey();
            int y2 = o2.getValue();
            return Integer.compare(x1 + y1, x2 + y2);
        });

        for (int i = 0; i < n; i++) {
            pairs.add(new Pairs<>(A.get(i), B.get(i)));
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = A.get(i);
                int y1 = B.get(i);
                int x2 = A.get(j);
                int y2 = B.get(j);

                if (x1 == x2 || y1 == y2) continue;
//
                Pairs<Integer, Integer> firstpoint = new Pairs<>(x1, y2);
                Pairs<Integer, Integer> secondpoint = new Pairs<>(x2, y1);
                if (pairs.contains(firstpoint) && pairs.contains(secondpoint)) {
                    count++;
                }
            }
        }

        return count/2;
    }

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(1, 1, 2, 2);
        List<Integer> B = Arrays.asList(1, 2, 1, 2);
       // System.out.println(solve(A, B));

        List<Integer> A1=Arrays.asList(9, 5, 1, 1, 3, 7, 7, 9, 6, 9, 2, 8);
        List<Integer> B1=Arrays.asList(8, 1, 5, 3, 8, 5, 4, 5, 2, 2, 7, 9);

        System.out.println(solve(A1, B1));

    }
}
