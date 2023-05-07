package N_Queens;

import java.util.ArrayList;

public class Test {
    private static ArrayList<String> createBoard(char[][] board) {
        ArrayList<String> l = new ArrayList<>();
        for (char[] chars : board) {
            String s = new String(chars);
            l.add(s);
        }
        return l;
    }

    public static void main(String[] args) {
        char [][] board= new char [4][4];
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                board[i][j]='.';
            }
        }
        board[0][1]='Q';
        board[1][3]='Q';
        board[2][1]='Q';
        board[3][2]='Q';

        System.out.println(createBoard((board)));
    }

}
