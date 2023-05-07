package B_Closest_Points_to_Origin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BClosestPointsToOrigin3 {
    public static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>((o1, o2) -> {
            int d1 = o1.get(0) * o1.get(0) + o1.get(1) * o1.get(1);
            int d2 = o2.get(0) * o2.get(0) + o2.get(1) * o2.get(1);
            return d2-d1;
        });
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int i;
        ArrayList<Integer> ele = null;
        for (i = 0; i < B; i++) {
            ele = new ArrayList<>();
            ele.add(A.get(i).get(0));
            ele.add(A.get(i).get(1));
            pq.add(ele);
        }

        for (i = B; i < A.size(); i++) {
            ele = new ArrayList<>();
            ele.add(A.get(i).get(0));
            ele.add(A.get(i).get(1));
            pq.add(ele);
            pq.poll();
        }

        i = 0;
        while (!pq.isEmpty()) {
            ele = pq.poll();
            ArrayList<Integer> list = new ArrayList<>();
            list.add(ele.get(0));
            list.add(ele.get(1));
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(48);
        l1.add(18);
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(46);
        l2.add(34);
        ArrayList<Integer> l3 = new ArrayList<>();
        l3.add(47);
        l3.add(30);
        ArrayList<Integer> l4 = new ArrayList<>();
        l4.add(19);
        l4.add(9);
        ArrayList<Integer> l5 = new ArrayList<>();
        l5.add(1);
        l5.add(39);
        ArrayList<Integer> l6 = new ArrayList<>();
        l6.add(95);
        l6.add(77);
        ArrayList<Integer> l7 = new ArrayList<>();
        l7.add(95);
        l7.add(106);
        ArrayList<Integer> l8 = new ArrayList<>();
        l8.add(78);
        l8.add(75);
        ArrayList<Integer> l9 = new ArrayList<>();
        l9.add(92);
        l9.add(108);
        ArrayList<Integer> l10 = new ArrayList<>();
        l10.add(89);
        l10.add(83);
        ArrayList<Integer> l11 = new ArrayList<>();
        l11.add(80);
        l11.add(76);

        input.add(l1);
        input.add(l2);
        input.add(l3);
        input.add(l4);
        input.add(l5);
        input.add(l6);
        input.add(l7);
        input.add(l8);
        input.add(l9);
        input.add(l10);
        input.add(l11);
        int B = 5;
        System.out.println(solve(input, B));
    }
}
