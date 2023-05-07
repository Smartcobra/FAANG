package Cycle_in_Undirected_Graph;

import java.util.ArrayList;

public class Cycle_Undirected {
    public int solve(int A, int[][] B) {
        ArrayList<Integer>[] adjList = createAdjacencyList(B, A);
        boolean[] vis = new boolean[A + 1];
        for (int i = 1; i <= A; i++) {
            if (!vis[i]) {
                if (dfs(adjList, vis, i, -1))
                    return 1;
            }
        }
        return 0;
    }

    private ArrayList<Integer>[] createAdjacencyList(int[][] matrix, int A) {

        ArrayList<Integer>[] g = new ArrayList[A + 1];

        for (int i = 0; i <= A; i++) {
            g[i] = new ArrayList<>();
        }

        for (int[] num : matrix) {
            int u = num[0];
            int v = num[1];
            g[u].add(v);
            g[v].add(u);
        }
        return g;
    }


    public boolean dfs(ArrayList<Integer>[] adj, boolean vis[], int node, int parent) {
        vis[node] = true;
        for (int it : adj[node]) {
            if (!vis[it]) {
                if (dfs(adj, vis, it, node)) return true;
            } else {
                if (it != parent)
                    return true;
            }
        }
        return false;
    }
}
