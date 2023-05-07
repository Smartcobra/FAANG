package Sum_Of_All_Submatrices_Of_A_Given_Matrix;

public class Solution {
    public static int matrixSum(int arr[][]) {
        int sum = 0;
        int R = arr.length;
        int C = arr[0].length;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int TL = (i + 1) * (j + 1);
                int BR = (R - i) * (C - j);
                int contribution = TL * BR * arr[i][j];
                sum += contribution;

            }
        }


        return sum;
    }

    public static void main(String[] args)
    {
        int arr[][] = {{1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}};

        System.out.println(matrixSum(arr));
    }
}
