package Task_Scheduling;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//https://www.scaler.com/academy/mentee-dashboard/class/35015/assignment/problems/9014?navref=cl_tt_lst_nm
public class TaskScheduling {

    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
       // int n = A.size();
        int ans = 0;

        Queue<Integer> q = new LinkedList<>(A);
        int i = 0;
        while (!q.isEmpty()) {
            int x = q.peek();
            if (x == B.get(i)) {
                ans++;
                q.remove();
                i++;
            } else {
                q.add(x);
                q.remove();
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(2);
        A.add(3);
        A.add(1);
        A.add(5);
        A.add(4);

        ArrayList<Integer> B = new ArrayList<>();
        B.add(1);
        B.add(3);
        B.add(5);
        B.add(4);
        B.add(2);
        System.out.println(solve(A, B));
    }


}
