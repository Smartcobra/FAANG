package Rotten_Oranges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair<K, V> {
    K first;
    V second;

    Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }
}

public class RottenOranges {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> matrix = A;
        int n = matrix.size();
        int m = matrix.get(0).size();
        int[][] time = new int[n][m];
        Arrays.stream(time).forEach(a -> Arrays.fill(a, -1));
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 2) {
                    Pair<Integer, Integer> p = new Pair<>(i, j);
                    q.add(p);
                    time[i][j] = 0;
                }
            }
        }

        int[] x = {-1, 0, 1, 0};
        int[] y = {0, 1, 0, -1};

        while (q.size() > 0) {
            Pair<Integer, Integer> d = q.peek();
            q.remove();
            int i = d.first;
            int j = d.second;

            for (int k = 0; k < 4; k++) {
                int a = i + x[k];
                int b = j + y[k];

                if (a >= 0 && a < n && b >= 0 && b < m && matrix.get(a).get(b) == 1) {
                    matrix.get(a).set(b, 2);
                    time[a][b] = time[i][j] + 1;
                    Pair<Integer, Integer> p = new Pair<>(a, b);
                    q.add(p);
                }
            }
        }
        for (ArrayList<Integer> integers : matrix) {
            for (int j = 0; j < m; j++) {
                if (integers.get(j) == 1) {
                    return -1;
                }
            }
        }
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, time[i][j]);
            }
        }
        return ans;
    }
}
