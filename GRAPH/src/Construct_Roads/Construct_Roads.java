package Construct_Roads;

import java.util.ArrayList;
import java.util.Arrays;

public class Construct_Roads {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        int MOD = 1000 * 1000 * 1000 + 7;
        ArrayList<ArrayList<Integer>> g = buildAdjList(A, B);

        int[] visited = new int[A + 1];
        Arrays.fill(visited, -1);

        visited[1] = 1;
        dfs(1, visited, g);

        long set1 = 0;
        long set2 = 0;

        for (int j : visited) {
            if (j == 0) {
                set1++;
            } else if (j == 1) {
                set2++;
            }
        }

        long totalsRoads = ( set1 % MOD * set2 % MOD) % MOD;
        long newRoads = totalsRoads - B.size();

        return (int) newRoads;

    }

    public void dfs(int source, int[] visited, ArrayList<ArrayList<Integer>> g) {

        ArrayList<Integer> neighbours = g.get(source);
        for (int cur : neighbours) {
            if (visited[cur] == -1) {
                visited[cur] = 1 ^ visited[source];
                dfs(cur, visited, g);
            }
        }
    }


    public ArrayList<ArrayList<Integer>> buildAdjList(int A, ArrayList<ArrayList<Integer>> B) {

        ArrayList<ArrayList<Integer>> g = new ArrayList<>();

        for (int i = 0; i <= A; i++) {
            g.add(i, new ArrayList<Integer>());
        }

        for (ArrayList<Integer> integers : B) {
            int u = integers.get(0);
            int v = integers.get(1);
            g.get(u).add(v);
            g.get(v).add(u);
        }

        return g;
    }
}
