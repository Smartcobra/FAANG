package Min_Sum_Path_in_Matrix;
///https://leetcode.com/problems/minimum-path-sum/
public class Solution {
    public int minPathSum(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;
        int[][] dp= new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }

        return minPathSumHelper(grid,0,0,m,n,dp);
    }

    public int minPathSumHelper(int[][] grid,int i, int j, int m,int n, int[][] dp) {

        if(i==m-1 && j==n-1){
            return grid[i][j];
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(i==m-1){
            return dp[i][j]= grid[i][j] + minPathSumHelper(grid,i,j+1,m,n,dp);
        }else if(j==n-1){
            return dp[i][j]= grid[i][j] + minPathSumHelper(grid,i+1,j,m,n,dp);
        }else{
            return dp[i][j]= grid[i][j] + Math.min(minPathSumHelper(grid,i+1,j,m,n,dp) ,minPathSumHelper(grid,i,j+1,m,n,dp));
        }
    }
}
