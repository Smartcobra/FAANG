package Count_Square_Submatrices_With_All_Ones;
///https://leetcode.com/problems/count-square-submatrices-with-all-ones/submissions/1435172246/
public class UsingMemo {
    public int countSquares(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int result=0;

        int[][] memo= new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                memo[i][j]=-1;
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1){
                   result +=solve(i,j,m,n,matrix,memo);
                }
            }
        }

        return result;
    }

    private int solve(int i, int j, int m, int n, int[][] matrix, int[][] memo) {
        if(i>=m || j>=n){
            return 0;
        }
        if(matrix[i][j]==0){
            return 0;
        }

        if(memo[i][j] !=-1){
            return memo[i][j];
        }

        int down = solve(i+1,j,m,n,matrix,memo);
        int right = solve(i,j+1,m,n,matrix,memo);
        int diag = solve(i+1,j+1,m,n,matrix,memo);

        return memo[i][j] = 1+Math.min(down,Math.min(right,diag));
    }
}
