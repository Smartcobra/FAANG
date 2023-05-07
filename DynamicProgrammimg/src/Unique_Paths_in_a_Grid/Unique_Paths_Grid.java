package Unique_Paths_in_a_Grid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Unique_Paths_Grid {
    public static int uniquePathsWithObstacles(ArrayList<List<Integer>> grid) {

        int r = grid.size();
        int c = grid.get(0).size();
        int[][] dp = new int[r + 1][c + 1];
        //if 0,0=1 return 0
        if (grid.get(0).get(0) == 1) {
            return 0;
        }
        if (grid.get(0).get(0) == 0) {
            dp[0][0] = 1;
        }
        ////first check the 1st row -0Th index row
        // If a cell originally contains a 1, this means the current cell has an obstacle and shouldn't contribute to any path. Hence, set the value of that cell to 0
        // Otherwise, set it to the value of previous cell i.e. obstacleGrid[i,j] = obstacleGrid[i,j-1]
        for (int i = 1; i < c; i++) {
            if (grid.get(0).get(i) == 1) {
                dp[0][i] = 0;
            } else if (grid.get(0).get(i) == 0) {
                dp[0][i] = dp[0][i - 1];
            }
        }

        ////first check the 1st col -0Th index row
        // If a cell originally contains a 1, this means the current cell has an obstacle and shouldn't contribute to any path. Hence, set the value of that cell to 0
        // Otherwise, set it to the value of previous cell i.e. obstacleGrid[i,j] = obstacleGrid[i-1,j]
        for (int i = 1; i < r; i++) {
            if (grid.get(i).get(0) == 1) {
                dp[i][0] = 0;
            } else if (grid.get(i).get(0) == 0) {
                dp[i][0] = dp[i - 1][0];
            }
        }

        ///now iterate through the grid from (1,1) and dp[i][j]=dp[i-1][j]+dp[i][j-1]

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (grid.get(i).get(j) == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[r - 1][c - 1];
    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(0, 0, 1, 0, 1, 1, 1, 1);
        List<Integer> list2 = Arrays.asList(0, 1, 0, 1, 0, 0, 1, 1);
        List<Integer> list3 = Arrays.asList(0, 0, 1, 0, 0, 0, 0, 1);
        ArrayList<List<Integer>> grid = new ArrayList<>();
        grid.add(list1);
        grid.add(list2);
        grid.add(list3);

        System.out.println(uniquePathsWithObstacles(grid));

    }
}
