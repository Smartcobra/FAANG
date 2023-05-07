package Beggars_Outside_Temple;


import java.util.ArrayList;

/*
*
* There are A beggars sitting in a row outside a temple. Each beggar initially has an empty pot.
*  When the devotees come to the temple, they donate some amount of coins to these beggars.
* Each devotee gives a fixed amount of coin(according to their faith and ability) to some K beggars sitting next to each other.

Given the amount P donated by each devotee to the beggars ranging from L to R index, where 1 <= L <= R <= A,
*  find out the final amount of money in each beggar's pot at the end of the day, provided they don't fill their pots by any other means.
For ith devotee B[i][0] = L, B[i][1] = R, B[i][2] = P, Given by the 2D array B*/
public class Solution {


    public static ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            ans.add(0);
        }

        for (int i = 0; i < B.size(); i++) {
            int start=B.get(i).get(0)-1;
            int end=B.get(i).get(1);
            int val= B.get(i).get(2);

            if(start>=0){
                ans.set(start,ans.get(start)+val);
            }
            if(end<A){
                ans.set(end,ans.get(end)-val);
            }
        }
        for (int i = 1; i < ans.size(); i++) {
            ans.set(i, (ans.get(i - 1) + ans.get(i)));
        }
        return ans;
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

        ArrayList<ArrayList<Integer>> l= new ArrayList<>();
        l.add(A);
        l.add(B);
        l.add(C);

        int a = 5;

        solve(a,l).stream().forEach(System.out::println);

    }
}
