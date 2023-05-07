package extraMatrixProblems.maximumsizesubsquarematrixwithall1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution_With_List {
    public static int getMatrixWith1(List<List<Integer>> A) {
        int ans = Integer.MIN_VALUE;
        ///create a dp list

        int[][] dp = new int[A.size()][A.get(0).size()];

        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                if (i == dp.length - 1 && j == dp[0].length - 1) {
                    dp[i][j] = A.get(i).get(j);
                } else if (i == dp.length - 1) {
                    dp[i][j] = A.get(i).get(j);
                } else if (j == dp[0].length - 1) {
                    dp[i][j] = A.get(i).get(j);
                } else {
                    if (A.get(i).get(j) == 0) {
                        dp[i][j] = 0;
                    } else {
                        int min = Math.min(dp[i][j+1],Math.min(dp[i+1][j+1],dp[i+1][j]));

                        dp[i][j] = 1 + min;

                        if (dp[i][j] > ans) {
                            ans = dp[i][j];
                        }
                    }

                }
            }
        }
        return ans;

    }

    public static void main(String[] args) {

        List<Integer> list1 = Stream.of(0, 1, 1, 0, 1)
                .collect(Collectors.toList());
        List<Integer> list2 = Stream.of(1, 1, 0, 1, 0)
                .collect(Collectors.toList());
        List<Integer> list3 = Stream.of(0, 1, 1, 1, 0)
                .collect(Collectors.toList());
        List<Integer> list4 = Stream.of(1, 1, 1, 1, 0)
                .collect(Collectors.toList());
        List<Integer> list5 = Stream.of(1, 1, 1, 1, 1)
                .collect(Collectors.toList());
        List<Integer> list6 = Stream.of(0, 0, 0, 0, 0)
                .collect(Collectors.toList());


        List<List<Integer>> Matrix = Stream.of(list1, list2, list3, list4, list5, list6).collect(Collectors.toList());

        int matrixWith1 = getMatrixWith1(Matrix);
        System.out.println(matrixWith1);
    }

}