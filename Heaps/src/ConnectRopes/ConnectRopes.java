package ConnectRopes;

import java.util.ArrayList;
import java.util.PriorityQueue;

//https://www.scaler.com/academy/mentee-dashboard/class/41002/assignment/problems/4385?navref=cl_tt_lst_nm
public class ConnectRopes {

    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        int cost = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(A.get(i));
        }

        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            int sum = x + y;
            pq.add(sum);

            cost = cost + sum;
        }
        return cost;
    }
}
