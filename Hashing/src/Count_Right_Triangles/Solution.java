package Count_Right_Triangles;
////https://www.scaler.com/academy/mentee-dashboard/class/29547/assignment/problems/4719/submissions

import java.util.*;

public class Solution {

    public static int solve(List<Integer> A, List<Integer> B) {
        int n = A.size();
        Map<Integer, Integer> mapA = new HashMap<>();
        Map<Integer, Integer> mapB = new HashMap<>();
        int result = 0;
        int MOD=1000*1000*1000+7;

        for (Integer a : A) {
            mapA.put(a, mapA.getOrDefault(a, 0) + 1);
        }

        for (Integer b : B) {
            mapB.put(b, mapB.getOrDefault(b, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            int countA = mapA.get(A.get(i)) - 1;
            int countB = mapB.get(B.get(i)) - 1;
            result += (countA * countB)%MOD;
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(1, 1, 2);
        List<Integer> B = Arrays.asList(1, 2, 1);
        System.out.println(solve(A,B));
    }
}
