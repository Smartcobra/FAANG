package Path_In_Directed_Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Path_In_Directed_Graph {
    public static int solve(int A, int[][] B) {
        int s = 1;
        //  int E=B.length+1; ///number of edges
        int[] U = new int[B.length];
        int[] V = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            U[i] = B[i][0];
            V[i] = B[i][1];
        }

        boolean isPathExist = findPathExists(A, A + 1, U, V, s, A);

        return isPathExist ? 1 : 0;
    }

    private static boolean findPathExists(int a, int E, int[] u, int[] v, int s, int d) {
        ArrayList<ArrayList<Integer>> g = new ArrayList<>(E);
        for (int i = 0; i < E; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < u.length; i++) {
            g.get(u[i]).add(v[i]);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        boolean[] visited = new boolean[E];
        visited[s] = true;

        while (q.size() > 0) {
            int cu = q.peek();
            q.remove();
            for (int i = 0; i < g.get(cu).size(); i++) {
                int cv = g.get(cu).get(i);
                if (!visited[cv]) {
                    visited[cv] = true;
                    q.add(cv);
                }
            }
        }
        return visited[d];
    }

    public static void main(String[] args) {
        int A = 2;
        int [][]B ={{1,2}};
        System.out.println(solve(A,B));
    }
}
