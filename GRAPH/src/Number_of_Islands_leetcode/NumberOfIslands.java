package Number_of_Islands_leetcode;
//////https://leetcode.com/problems/number-of-islands/
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int r = grid.length;
        int c = grid[0].length;
        int ans = 0;
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (grid[i][j] == '1') {
                    ans++;
                    dfs(grid, i, j, r, c);
                }
            }
        }

        return ans;
    }

    public void dfs(char[][] grid, int i, int j, int r, int c) {

        if (i < 0 || j < 0 || i >= r || j >= c || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        //Make recursive call in all 4 adjacent directions
        dfs(grid, i + 1, j, r, c);  //DOWN
        dfs(grid, i - 1, j, r, c);  //TOP
        dfs(grid, i, j + 1, r, c);  //RIGHT
        dfs(grid, i, j - 1, r, c);  //LEFT
    }

}
