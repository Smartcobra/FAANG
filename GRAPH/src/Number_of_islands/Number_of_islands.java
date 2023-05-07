package Number_of_islands;

import java.util.ArrayList;

////https://www.scaler.com/academy/mentee-dashboard/class/35035/homework/problems/4702?navref=cl_tt_lst_nm
public class Number_of_islands {

    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        int c = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A.get(i).get(j) == 1) {
                    c++;
                    dfs(A, i, j, n, m);
                }
            }
        }
        return c;
    }

    private void dfs(ArrayList<ArrayList<Integer>> matrix, int i, int j, int row, int col) {
        if (i < 0 || j < 0 || i >= row || j >= col || matrix.get(i).get(j) == 0){
            return;
        }

        matrix.get(i).set(j,0);// mark visited

        dfs(matrix,i-1,j,row,col);
        dfs(matrix,i,j-1,row,col);
        dfs(matrix,i+1,j,row,col);
        dfs(matrix,i,j+1,row,col);
        dfs(matrix,i-1,j-1,row,col);
        dfs(matrix,i+1,j+1,row,col);
        dfs(matrix,i-1,j+1,row,col);
        dfs(matrix,i+1,j-1,row,col);

    }

}
