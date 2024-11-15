package N_Queens;

public class N_Queens_II {
    public int totalNQueens(int n) {
        int[][] board= new int[n][n];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }

        return queens(board,0);
    }

    private int queens(int[][] board, int row) {
        int n= board.length;
        if(row==n){
            return 1;

        }
        int count = 0;

        for(int j=0;j<n;j++){
            if(isSafe(board,row,j)){
                board[row][j]='Q';
                count += queens(board,row+1);
                board[row][j]='.';
            }
        }
        return count;
    }

    private boolean isSafe(int[][] board, int row, int col) {
        int n= board.length;
        ///row
        for(int j=0;j<n;j++){
            if(board[row][j]=='Q') return false;
        }
        //col
        for(int i=0;i<n;i++){
            if(board[i][col]=='Q') return false;
        }

        int i=row;
        int j=col;

        //NW
        while(i>=0 && j>=0){
            if(board[i][j]=='Q') return false;
            i--;j--;
        }
        i=row;
        j=col;

        //NE
        while(i>=0 && j<n){
            if(board[i][j]=='Q') return false;
            i--;j++;
        }
        i=row;
        j=col;
        //SE
        while(i<n && j<n){
            if(board[i][j]=='Q') return false;
            i++;j++;
        }
        i=row;
        j=col;
        //SW
        while(i<n && j>=0){
            if(board[i][j]=='Q') return false;
            i++;j--;
        }

        return true;


    }
}
