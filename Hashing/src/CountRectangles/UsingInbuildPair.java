package CountRectangles;

import javafx.util.Pair;

import java.util.*;

public class UsingInbuildPair {
    private static int getCountOfRectangles(List<Integer> A, List<Integer> B) {
        Set<Pair<Integer, Integer>> set = new TreeSet<>((o1, o2) -> {
            int x1 = o1.getKey(); // first key
            int y1 = o1.getValue(); // first value
            int x2 = o2.getKey(); // second key
            int y2 = o2.getValue(); // second value
            return Integer.compare(x1 + y1, x2 + y2);
        });

        for (int i = 0; i < A.size(); i++) {
            set.add(new Pair<>(A.get(i), B.get(i)));
        }

        int count = 0;
        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                int x1 = A.get(i);
                int y1 = B.get(i);
                int x2 = A.get(j);
                int y2 = B.get(j);

                // check for diagonal elements, if not continue
                if (x1 == x2 || y1 == y2) continue;

                // Check for these pairs in set whether it exists or not (these are other coordinates)
                Pair<Integer, Integer> firstPoint = new Pair<>(x1, y2);
                Pair<Integer, Integer> secondPoint = new Pair<>(x2, y1);
                if (set.contains(firstPoint) && set.contains(secondPoint)) {
                    count++;
                }
            }
        }

        return count / 2;
    }

    public static void main(String[] args) {
        List<Integer> A1= Arrays.asList(9, 5, 1, 1, 3, 7, 7, 9, 6, 9, 2, 8);
        List<Integer> B1=Arrays.asList(8, 1, 5, 3, 8, 5, 4, 5, 2, 2, 7, 9);

        System.out.println(getCountOfRectangles(A1, B1));    ///failed for this input
    }
}
