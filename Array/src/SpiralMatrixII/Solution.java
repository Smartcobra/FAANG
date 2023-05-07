package SpiralMatrixII;

public class Solution {
    public static int[][] generateMatrix(int N) {

        int r1 = 0;  // start of row
        int r2 = N - 1;  //end of row
        int c1 = 0;     //start of col
        int c2 = N - 1;    //end of col

        int[][] result = new int[N][N];

        int val = 1;

        while (r1 <= r2 && c1 <= c2) {
            // from left to right
            // r1 is constant and 0
            for (int i = c1; i <= c2; i++) {
                result[r1][i] = val++;
            }
            // from top right to bottom right
            // c2 is constant and we need travel from r1+1
            for (int i = r1 + 1; i <= r2; i++) {
                result[i][c2] = val++;
            }
            if (r1 < r2 && c1 < c2) {
                //right to left
                for (int i = c2 - 1; i >= c1; i--) {
                    result[r2][i] = val++;
                }
                // bottom left to top left
                for (int i = r2 - 1; i > r1; i--) {
                    result[i][c1] = val++;
                }
            }


            r1++;
            r2--;
            c1++;
            c2--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] ints = generateMatrix(3);
        for(int i=0;i<ints.length;i++){
            for(int j=0;j<ints[0].length;j++){
                System.out.print(ints[i][j] +" ");
            }
            System.out.println();
        }
    }


}
