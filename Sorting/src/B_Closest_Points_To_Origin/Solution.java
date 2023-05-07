package B_Closest_Points_To_Origin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (A.size() == 1 || A.size() == 0) return A;

        Collections.sort(A, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> A1, ArrayList<Integer> A2) {
                int sum1 = A1.get(0) * A1.get(0) + A1.get(1) * A1.get(1);
                int sum2 = A2.get(0) * A2.get(0) + A2.get(1) * A2.get(1);
                return sum1 > sum2 ? 1 : -1;
            }
        });

        for (int i = 0; i < B; i++) {
            int p1 = A.get(i).get(0);
            int p2 = A.get(i).get(1);
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(p1);
            tmp.add(p2);
            result.add(tmp);
        }
        return result;
    }
}
