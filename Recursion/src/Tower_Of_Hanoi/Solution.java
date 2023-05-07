package Tower_Of_Hanoi;

import java.util.ArrayList;

public class Solution {

    public static ArrayList<ArrayList<Integer>> towerOfHanoi(int A) {
        int s = 1;
        int t = 2;
        int d = 3;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        towerOfHanoiHelper(A, s, t, d, result);
        return result;
    }

    private static void towerOfHanoiHelper(int A, int s, int t, int d, ArrayList<ArrayList<Integer>> result) {
        ArrayList<Integer> tmp = new ArrayList<>();
        if (A == 0) return;
        towerOfHanoiHelper(A - 1, s, d, t, result);
        tmp.add(A);
        tmp.add(s);
        tmp.add(d);
        result.add(tmp);
        towerOfHanoiHelper(A - 1, t, s, d, result);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a = towerOfHanoi(2);
        a.forEach(t -> t.forEach(System.out::println));

    }

   // 112   213  123
}
