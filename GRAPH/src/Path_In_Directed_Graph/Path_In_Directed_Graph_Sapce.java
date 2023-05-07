package Path_In_Directed_Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Path_In_Directed_Graph_Sapce {
    public static int solve(int A, int[][] B) {
        int s = 1;  /// source
        //  int E=B.length+1; ///number of edges
         //A-> destination
        boolean isPathExist = findPathExists(A, B, s, A);

        return isPathExist ? 1 : 0;
    }

    private static boolean findPathExists(int a, int[][] B, int s, int d) {
        ArrayList<ArrayList<Integer>> g = new ArrayList<>(a+1);
        for (int i = 0; i < a+1; i++) {
            g.add(new ArrayList<>());
        }
//        for (int i = 0; i < B.length; i++) {
//            g.get(B[i][0]).add(B[i][1]);
//        }
        for (int[] b : B) {
            g.get(b[0]).add(b[1]);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        boolean[] visited = new boolean[a+1];
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
