package Beggars_Outside_Temple;

import java.util.ArrayList;

public class Solution2 {

    public static ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            ans.add(0);
        }

        for (int i = 0; i < B.size(); i++) {
            int start=B.get(i).get(0)-1;
            int end=B.get(i).get(1);
            int val= B.get(i).get(2);

            for (int j = start; j <end; j++) {
                ans.set(j, ans.get(j)+val);
            }
        }

        return ans;
    }
//   time complexity (n*R)

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

        ArrayList<ArrayList<Integer>> l= new ArrayList<>();
        l.add(A);
        l.add(B);
        l.add(C);

        int a = 5;

        solve(a,l).stream().forEach(System.out::println);

    }
}
