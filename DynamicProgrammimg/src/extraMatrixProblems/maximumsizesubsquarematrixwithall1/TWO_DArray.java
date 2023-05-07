package extraMatrixProblems.maximumsizesubsquarematrixwithall1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TWO_DArray {

    public static int solution( List<List<Integer>> A) {
        int ans = Integer.MAX_VALUE;
        ///create a dp list

        List<ArrayList<Integer>> dp = new ArrayList<ArrayList<Integer>>();

        for (int i = A.size() - 1; i >= 0; i--) {
            for (int j = A.get(0).size() - 1; j >= 0; j--) {
                if (i == A.size() - 1 && j == A.get(0).size() - 1) {
                    System.out.println(A.get(i));
                }
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        List<List<Integer>> myList = new ArrayList<List<Integer>>();

        List<Integer> list1 = Stream.of(0,1,1,0,1)
                .collect(Collectors.toList());
        List<Integer> list2 = Stream.of(1,1,0,1,0)
                .collect(Collectors.toList());
        List<Integer> list3 = Stream.of(0,1,1,1,0)
                .collect(Collectors.toList());
        List<Integer> list4 = Stream.of(1,1,1,1,0)
                .collect(Collectors.toList());
        List<Integer> list5 = Stream.of(1,1,1,1,1)
                .collect(Collectors.toList());
        List<Integer> list6 = Stream.of(0,0,0,0,0)
                .collect(Collectors.toList());


        List<List<Integer>> Matrix = Stream.of(list1, list2, list3, list4, list5, list6).collect(Collectors.toList());

        solution(Matrix);


    }
}
