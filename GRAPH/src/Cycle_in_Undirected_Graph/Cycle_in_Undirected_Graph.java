package Cycle_in_Undirected_Graph;

import java.util.ArrayList;

public class Cycle_in_Undirected_Graph {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
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

    private ArrayList<Integer>[] createAdjacencyList(ArrayList<ArrayList<Integer>> matrix, int A) {

        ArrayList<Integer>[] g = new ArrayList[A + 1];

        for (int i = 0; i <= A; i++) {
            g[i] = new ArrayList<>();
        }

        for (ArrayList<Integer> num : matrix) {
            int u = num.get(0);
            int v = num.get(1);
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

    public static void main(String[] args) {
       /*int  A = 5;
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        ArrayList<Integer> b1= new ArrayList<>();
        b1.add(1);b1.add(2);
        ArrayList<Integer> b2= new ArrayList<>();
        b2.add(1);b2.add(3);
        ArrayList<Integer> b3= new ArrayList<>();
        b3.add(2);b3.add(3);
        ArrayList<Integer> b4= new ArrayList<>();
        b4.add(1);b4.add(4);
        ArrayList<Integer> b5= new ArrayList<>();
        b5.add(4);b5.add(5);
        B.add(b1);
        B.add(b2);
        B.add(b3);
        B.add(b4);
        B.add(b5);
        Cycle_in_Undirected_Graph c= new Cycle_in_Undirected_Graph();
        System.out.println(c.solve(A,B));*/


        int A = 2;
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        ArrayList<Integer> b1 = new ArrayList<>();
        b1.add(1);
        b1.add(2);
        B.add(b1);
        Cycle_in_Undirected_Graph c = new Cycle_in_Undirected_Graph();
        System.out.println(c.solve(A, B));


    }

}
