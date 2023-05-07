package Beggars_Outside_Temple;

import java.util.ArrayList;

public class BruteForce {
    public static ArrayList<Integer> solve_bru(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < A; i++) {
            result.add(0);
        }
        for (int i = 0; i < B.size(); i++) {
            int s = B.get(i).get(0) - 1;
            int e = B.get(i).get(1) - 1;
            int value = B.get(i).get(2);

            populate(result, s, e, value);
        }

        return result;
    }

    public static void populate(ArrayList<Integer> A, int s, int e, int value) {
        for (int i = s; i <= e; i++) {
            A.set(i, A.get(i) + value);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(10);

        ArrayList<Integer> B = new ArrayList<>();
        B.add(2);
        B.add(3);
        B.add(20);

        ArrayList<Integer> C = new ArrayList<>();
        C.add(2);
        C.add(5);
        C.add(25);

        ArrayList<ArrayList<Integer>> l = new ArrayList<>();
        l.add(A);
        l.add(B);
        l.add(C);

        int a = 5;

        solve_bru(a, l).stream().forEach(System.out::println);

    }
}
