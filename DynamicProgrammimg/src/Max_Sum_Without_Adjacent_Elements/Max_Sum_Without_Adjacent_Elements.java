package Max_Sum_Without_Adjacent_Elements;

import java.util.ArrayList;
///https://www.scaler.com/academy/mentee-dashboard/class/35030/assignment/problems/278/?navref=cl_pb_nv_tb

public class Max_Sum_Without_Adjacent_Elements {
    public static int adjacent(ArrayList<ArrayList<Integer>> A) {
        int n = A.get(0).size();
        int[] tmp = new int[n];
        int[] dp = new int[n + 1];
        if(n<=1){
            return Math.max(A.get(0).get(0),A.get(1).get(0));
        }

        for (int i = 0; i < n; i++) {
            tmp[i] = Math.max(A.get(0).get(i), A.get(1).get(i));
        }
        dp[0] = tmp[0];
        dp[1] = Math.max(dp[0],tmp[1]);
        for (int i = 2; i < tmp.length; i++) {
            dp[i] = Math.max(dp[i - 1], tmp[i] + dp[i - 2]);
        }
        return dp[tmp.length-1];
    }

    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(74);
//        list.add(37);
//        list.add(82);
//        list.add(1);
//        ArrayList<Integer> list2 = new ArrayList<>();
//        list2.add(66);
//        list2.add(38);
//        list2.add(16);
//        list2.add(1);
//        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
//        A.add(list);
//        A.add(list2);
//        System.out.println(adjacent(A));

        //////////
//        ArrayList<Integer> list3 = new ArrayList<>();
//        list3.add(28);
//        ArrayList<Integer> list4 = new ArrayList<>();
//        list4.add(10);
//
//        ArrayList<ArrayList<Integer>> A2 = new ArrayList<>();
//        A2.add(list3);
//        A2.add(list4);
//        System.out.println(adjacent(A2));

    }
}
