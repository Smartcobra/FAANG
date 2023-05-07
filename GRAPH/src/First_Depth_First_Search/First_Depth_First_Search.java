package First_Depth_First_Search;

import java.util.ArrayList;

public class First_Depth_First_Search {
    public static int solve(int[] A, final int B, final int C) {
        //create adjacent list
        boolean[] visited = new boolean[A.length + 1];
        ArrayList<ArrayList<Integer>> g = new ArrayList<>(A.length + 1);

        for (int i = 0; i <= A.length; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < A.length; i++) {
            g.get(A[i]).add(i + 1);
        }
        dfs(g, visited, C);

        return visited[B] ? 1 : 0;

    }

//    public ArrayList<Integer>[] adjacency(ArrayList<Integer> A) {
//
//        ArrayList<Integer>[] adj = new ArrayList[A.size() + 1];
//
//        for (int i = 0; i <= A.size(); i++) {
//            adj[i] = new ArrayList<>();
//        }
//
//        for (int i = 0; i < A.size(); i++) {
//            int source = A.get(i);
//            adj[source].add(i + 1);
//        }
//        return adj;
//    }

    private static void dfs(ArrayList<ArrayList<Integer>> g, boolean[] visited, int s) {
        if (visited[s]) return;

        visited[s] = true;

        for (int i = 0; i < g.get(s).size(); i++) {
            int v = g.get(s).get(i);
            dfs(g, visited, v);
        }
    }

    public static void main(String[] args) {
//        int[] A = {1, 1, 2};
//        int B = 1;
//        int C = 2;

        int[] A = {1, 1, 1, 3, 3, 2, 2, 7, 6};
        int B = 2;
        int C = 8;

        System.out.println(solve(A, B, C));
    }
}
