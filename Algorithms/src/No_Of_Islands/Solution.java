package No_Of_Islands;

/*
* Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
*
*
* Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
*
*
*
*

    Time complexity : O(M×N)

    Space complexity : worst case O(M×N)


* */

public class Solution {

    void mark_current_island(char[][] grid, int x,int y,int r,int c) {

        if(x<0 || x>=r || y<0 || y>=c || grid[x][y]!='1')  //Boundary case for matrix
            return;

        grid[x][y] = '2';
        //Make recursive call in all 4 adjacent directions
        mark_current_island(grid,x+1,y,r,c);  //DOWN
        mark_current_island(grid,x,y+1,r,c);  //RIGHT
        mark_current_island(grid,x-1,y,r,c);  //TOP
        mark_current_island(grid,x,y-1,r,c);  //LEFT
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int r = grid.length;
        int c = grid[0].length;
        int num_islands = 0;
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (grid[i][j] == '1') {
                    mark_current_island(grid,i,j,r,c);
                    ++num_islands;
                }
            }
        }

        return num_islands;
    }

}

