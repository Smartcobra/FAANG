package AntiDiagonals;

import java.util.ArrayList;

/*
Give a N * N square matrix A, return an array of its anti-diagonals. Look at the example for more details.

        Problem Constraints

        1<= N <= 1000
        1<= A[i][j] <= 1e9

        Input Format

        First argument is an integer N, denoting the size of square 2D matrix.
        Second argument is a 2D array A of size N * N.

        Output Format

        Return a 2D integer array of size (2 * N-1) * N, representing the anti-diagonals of input array A.
        The vacant spaces in the grid should be assigned to 0.

*/
public class Solution {
    public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> list) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int N = list.size();
        int M = list.get(0).size();
        int x = 0;
        int y = 0;
///step-1

        for (int j = 0; j < M; j++) {
            x = 0;
            y = j;

            while (x < N && y >= 0) {
                System.out.print(list.get(x).get(y));

                x++;
                y--;
            }
            System.out.println();
        }
//step-2
        for (int i = 1; i < N; i++) {
            x = i;
            y = M - 1;
            while (x < N && y >= 0) {
                System.out.print(list.get(x).get(y));

                x++;
                y--;
            }
            System.out.println();
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(4);
        l2.add(5);
        l2.add(6);
        ArrayList<Integer> l3 = new ArrayList<>();
        l3.add(7);
        l3.add(8);
        l3.add(9);

        ArrayList<ArrayList<Integer>> di = new ArrayList<>();
        di.add(l1);
        di.add(l2);
        di.add(l3);

        diagonal(di);

    }
}















