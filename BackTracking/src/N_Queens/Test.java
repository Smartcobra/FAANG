package N_Queens;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        nQueen(board, 0, ans);
        return ans;
    }

    private void nQueen(char[][] board, int row, List<List<String>> ans) {
        int n= board.length;
        if(row==n){
            List<String> l = new ArrayList<>();
            for(int i=0;i<n;i++){
                String str ="";
                for(int j=0;j<n;j++){
                    str = str+board[i][j];
                }
                l.add(str);
            }

            ans.add(l);
            return;
        }

        for(int j=0;j<n;j++){
            if(isSafe(board,ans,row,j)){
                board[row][j]='Q';
                nQueen(board,row+1,ans);
                board[row][j]='.';
            }
        }
    }

    private boolean isSafe(char[][] board, List<List<String>> ans, int row, int col) {
        int n=board.length;

        //row
        for(int j=0;j<n;j++){
            if(board[row][j] == 'Q') return false;
        }

        //col
        for(int i=0;i<n;i++){
            if(board[i][col] == 'Q') return false;
        }

        //NW
        int i=row;
        int j=col;
         while(i>=0 && j>=0){
             if(board[i][j]=='Q') return false;
             i--;j--;
         }

        //NE
         i=row;
         j=col;
        while(i>=0 && j<n){
            if(board[i][j]=='Q') return false;
            i--;j++;
        }

        //SE
        i=row;
        j=col;
        while(i<n && j<n){
            if(board[i][j]=='Q') return false;
            i++;j++;
        }

        //SW
        i=row;
        j=col;
        while(i<n && j>=0){
            if(board[i][j]=='Q') return false;
            i++;j--;
        }

        return true;
    }


}
