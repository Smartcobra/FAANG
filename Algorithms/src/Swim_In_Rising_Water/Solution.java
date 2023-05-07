package Swim_In_Rising_Water;

//https://leetcode.com/problems/swim-in-rising-water/

import java.util.PriorityQueue;

public class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<Pair> q = new PriorityQueue();
        q.add(new Pair(0, 0, grid[0][0]));

        boolean[][] vis = new boolean[n][n];

        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while (!q.isEmpty()) {
            Pair rem = q.remove();

            if (rem.row == n - 1 && rem.col == n - 1) {
                return rem.msp;
            }
            if (vis[rem.row][rem.col]) {
                continue;
            }

            vis[rem.row][rem.col] = true;

            for (int i = 0; i < 4; i++) {
                int rowdas = rem.row + dirs[i][0];
                int coldas = rem.col + dirs[i][1];

                if (rowdas < 0 || coldas < 0 || rowdas >= n || coldas >= n || vis[rowdas][coldas]) {
                    continue;
                }
                q.add(new Pair(rowdas, coldas, Math.max(rem.msp, grid[rowdas][coldas])));
            }

        }
        return 0;
    }


}

class Pair implements Comparable<Pair> {
    int row;
    int col;
    int msp;

    public Pair(int row, int col, int msp) {
        this.row = row;
        this.col = col;
        this.msp = msp;
    }

    @Override
    public int compareTo(Pair o) {
        return this.msp - o.msp;
    }
}