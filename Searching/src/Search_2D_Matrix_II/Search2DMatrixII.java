package Search_2D_Matrix_II;
//https://leetcode.com/problems/search-a-2d-matrix-ii/
public class Search2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        int i = 0;
        int j = c-1;

        while(i<r && j>=0){
            if(matrix[i][j]==target){
                return true;
            }else if(matrix[i][j] < target){
                i++;
            }else{
                j--;
            }
        }

        return false;
    }
}
