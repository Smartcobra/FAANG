package Check_Knight_Tour_Configuration;

/////https://leetcode.com/problems/check-knight-tour-configuration/
public class Solution {
    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) return false;
        return helper(grid, 0, 0, 0);

    }

    private boolean helper(int[][] grid, int row, int col, int num) {
        int n = grid.length;

        if(grid[row][col]==n*n-1) return true;
        int i, j;
        //2up-1right
        i = row - 2;
        j = col + 1;
        if (i >= 0 && j < n && grid[i][j] == num + 1) {
            return helper(grid, i, j, num + 1);
        }

        //2up-1left
        i = row - 2;
        j = col - 1;
        if (i >= 0 && j >= 0 && grid[i][j] == num + 1) {
            return helper(grid, i, j, num + 1);
        }

        //2down-1left
        i = row + 2;
        j = col - 1;
        if (i < n && j >= 0 && grid[i][j] == num + 1) {
            return helper(grid, i, j, num + 1);
        }
        //2down-1right
        i = row + 2;
        j = col + 1;
        if (i < n && j < n && grid[i][j] == num + 1) {
            return helper(grid, i, j, num + 1);
        }

        //1up-2right
        i = row - 1;
        j = col + 2;
        if (i >= 0 && j < n && grid[i][j] == num + 1) {
            return helper(grid, i, j, num + 1);
        }

        //1down-2right
        i = row + 1;
        j = col + 2;
        if (i < n && j < n && grid[i][j] == num + 1) {
            return helper(grid, i, j, num + 1);
        }

        //1up-2left
        i = row - 1;
        j = col - 2;
        if (i >= 0 && j >= 0 && grid[i][j] == num + 1) {
            return helper(grid, i, j, num + 1);
        }

        //1down-2left
        i = row + 1;
        j = col - 2;
        if (i < n && j >= 0 && grid[i][j] == num + 1) {
            return helper(grid, i, j, num + 1);
        }

        return false;
    }
}
