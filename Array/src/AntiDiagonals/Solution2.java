package AntiDiagonals;

import java.util.ArrayList;

public class Solution2 {
    public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> list) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int N = list.size();
        int M = list.get(0).size();
        int x = 0;
        int y = 0;
        int total = 2 * N - 1;
        int k = 0;

        for (int i = 0; i < total; i++) {
            result.add(new ArrayList<Integer>(N));
            for (int j = 0; j < N; j++) {
                result.get(i).add(0);
            }
        }

        for (int i = 0; i < total; i++) {
            if (i < N) {
                x = 0;
                y = i;
                while (x < N && y >= 0) {
                    int cellValue = list.get(x).get(y);
                    result.get(i).set(x, cellValue);
                    x++;
                    y--;
                }
            } else {
                x = i - N + 1;
                y = N - 1;
                while (x < N && y >= 0) {
                    int cellValue = list.get(x).get(y);
                    result.get(i).set(x+N-i-1, cellValue);
                    x++;
                    y--;
                }
            }
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

        ArrayList<ArrayList<Integer>> diagonal = diagonal(di);
        System.out.println("*******");
        for (int i = 0; i < diagonal.size(); i++) {
            for (int j = 0; j < diagonal.get(0).size(); j++) {
                System.out.print(diagonal.get(i).get(j));
            }
            System.out.println();
        }

    }


}















