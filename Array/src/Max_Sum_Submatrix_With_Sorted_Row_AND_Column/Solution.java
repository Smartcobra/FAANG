package Max_Sum_Submatrix_With_Sorted_Row_AND_Column;


// we can use kadens here but TC is more compare to this solution
public class Solution {
    public static int maxSubMatSum(int[][] arr) {

        int R = arr.length;
        int C = arr[0].length;
        int[][] prefix_row = new int[R][C];
        int[][] prefixArr = new int[R][C];
        int sum = 0;
        int maxsum = Integer.MIN_VALUE;

        for (int i = 0; i < R; i++) {
            prefix_row[i][0] = arr[i][0];
            for (int j = 1; j < C; j++) {
                prefix_row[i][j] = prefix_row[i][j - 1] + arr[i][j];
            }
        }

        /// prefixMatrix
        for (int i = 0; i < C; i++) {
            prefixArr[0][i] = prefix_row[0][i];
            for (int j = 1; j < R; j++) {
                prefixArr[j][i] = prefixArr[j - 1][i] + prefix_row[j][i];
            }
        }


        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                //a1=i
                //b1=j
                int a2 = R - 1;
                int b2 = C - 1;
                sum = prefixArr[a2][b2];
                if (i != 0) {
                    sum -= prefixArr[i - 1][b2];
                }
                if (j != 0) {
                    sum -= prefixArr[a2][j - 1];
                }
                if (i != 0 && j != 0) {
                    sum += prefixArr[i - 1][j - 1];

                }
                maxsum = Math.max(sum, maxsum);

            }
        }

        return maxsum;
    }
    public static void main(String[] args)
    {
        // Given matrix mat[][]
        int [][]mat= {   { -6, -4, -1 },
                         { -3, 2, 4 },
                          { 2, 5, 8 } };

        // Function Call
        System.out.print(maxSubMatSum(mat));
    }
}
