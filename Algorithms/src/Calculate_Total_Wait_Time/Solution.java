package Calculate_Total_Wait_Time;

/*
*
* Calculate the total wait time for a customer C to speak to an agent given N agents, M customers, and T[] time for an agent to serve a customer. T[i] represents the amount of time it takes for an agent i to serve one customer. One agent can serve one customer at a time. All N agents can serve concurrently. The customer chooses the agent with the lowest wait time.

Examples:

N = 2
M = 2
T = [4, 5]
First customer chooses agent 1. Second customer chooses agent 2.
Customer C will wait 4 minutes.

N = 2
M = 4
T = [4, 5]
First customer chooses agent 1. Second customer chooses agent 2.
Third customer chooses agent 1. Forth customer chooses agent 2.
Customer C will wait 8 minutes.

Initial questions:

Bounds on N and M - No bounds
Can N or M be zero - Both can be zero
Are the T values constant - Yes
Are the T values integers - Yes
*
* */

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static int[] getAns(int M, int N, int[] T) {
        int n= T.length;
        System.out.println(n);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[0]));
        for (int i = 0; i < N; i++){
            pq.add(new int[]{T[i], T[i], i});
        }

        for (int i = 0; i < M; i++) {
            int[] curr = pq.remove();
            pq.add(new int[]{curr[0] + curr[1], curr[1], curr[2]});
        }

        return pq.remove();
    }

    public static void main(String[] args) {
//        int N = 2;
//       int M = 2;
//        int[]T = {4, 5};

        int N = 2;
        int M = 4;
        int[] T = {4, 5};
        int [] ans=getAns(N,M,T);
        System.out.println(ans[0]);
    }
}
