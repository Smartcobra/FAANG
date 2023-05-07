package DungeonPrincess;

import java.util.ArrayList;

public class DungeonPrincess {
    public int calculateMinimumHP(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        return calculateMinimumHP_Helper(0, 0, matrix);
    }

    public int calculateMinimumHP_Helper(int i, int j, int[][] matrix) {
        if (i >= matrix.length || j >= matrix[0].length) {
            return Integer.MAX_VALUE;
        }
        int health = Math.min(calculateMinimumHP_Helper(i + 1, j, matrix), calculateMinimumHP_Helper(i, j + 1, matrix));

        if (health == Integer.MAX_VALUE) {
            health = 1;
        }
        int ans = 0;

        if (health - matrix[i][j] > 0) {
            ans = health - matrix[i][j];
        } else {
            ans = 1;
        }

        return ans;
    }

}
