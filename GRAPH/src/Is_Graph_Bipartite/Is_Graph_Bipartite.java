package Is_Graph_Bipartite;

import java.util.ArrayList;

//0-> no color
//1->blue
//-1->red
public class Is_Graph_Bipartite {
    public boolean isBipartite(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer>[] g = createAdjList(A, B);
        int[] colors = new int[A];
        for (int i = 0; i < A; i++) {
            if (colors[i] == 0 && !isValidColor(g, colors, 1, i)) return false;

        }
        return true;

    }

    private boolean isValidColor(ArrayList<Integer>[] g, int[] colors, int color, int node) {

        if (colors[node] != 0) {
            return colors[node] == color;
        }
        colors[node] = color;

        for (Integer n : g[node]) {
            if (!isValidColor(g, colors, -color, n)) return false;
        }

        return true;
    }

    private ArrayList<Integer>[] createAdjList(int A, ArrayList<ArrayList<Integer>> matrix) {

        ArrayList<Integer>[] g = new ArrayList[A];

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
}
