package Minimum_Falling_Path_Sum;
///https://leetcode.com/problems/minimum-falling-path-sum/
public class MinimumFallingPathSum {
    public int findMinFallingPathSum(int[][] matrix){
        int minFallingSum=Integer.MAX_VALUE;
        for(int i=0;i<matrix[0].length;i++){
            minFallingSum=Math.min(minFallingSum,findMinFallingPathSum_Helper(matrix,0,i));
        }
        return minFallingSum;
    }

    private int findMinFallingPathSum_Helper(int[][] matrix, int row, int col) {
        if(col< 0 || col==matrix[0].length){
            return Integer.MAX_VALUE;
        }

        if(row==matrix.length-1){
            return matrix[row][col];
        }
        int left=findMinFallingPathSum_Helper(matrix,row+1,col-1);
        int mid=findMinFallingPathSum_Helper(matrix,row+1,col);
        int right=findMinFallingPathSum_Helper(matrix,row+1,col+1);

        return matrix[row][col]+Math.min(left,Math.min(mid,right));
    }
}
