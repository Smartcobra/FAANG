package Djkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pair<K, V> {
    K node;
    V distance;

    Pair(K node, V distance) {
        this.node = node;
        this.distance = distance;
    }
}

public class Solution_Djkstra {
    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B, int C) {
        int[] distance = new int[A];
        Arrays.fill(distance, Integer.MAX_VALUE);
        ArrayList<ArrayList<Pair<Integer, Integer>>> g = buildAdjList(A, B);
        distance[C] = 0;

        PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        minHeap.add(new Pair<>(C, 0));

        while (minHeap.size() > 0) {
            Pair<Integer, Integer> data = minHeap.peek();
            minHeap.remove();
            int node = data.node;
            int dis = data.distance;
            ////already reached
            if (dis > distance[node]) {
                continue;
            }
            // we are blasting
            //update new blast time
            for (int i = 0; i < g.get(node).size(); i++) {  // neighbours
                Pair<Integer, Integer> neigbours = g.get(node).get(i);
                int v = neigbours.node;
                int w = neigbours.distance;
                if (dis + w < distance[v]) {
                    distance[v] = dis + w;
                    minHeap.add(new Pair<>(v, distance[v]));
                }
            }
        }


        ArrayList<Integer> distances = new ArrayList<>();
        for (int a : distance) {
            if (a == Integer.MAX_VALUE) {
                distances.add(-1);
            } else {
                distances.add(a);
            }

        }

        return distances;
    }

    private ArrayList<ArrayList<Pair<Integer, Integer>>> buildAdjList(int N, ArrayList<ArrayList<Integer>> matrix) {
        ArrayList<ArrayList<Pair<Integer, Integer>>> g = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            g.add(new ArrayList<>());
        }

        for (ArrayList<Integer> nums : matrix) {
            int u = nums.get(0);
            int v = nums.get(1);
            int w = nums.get(2);

            Pair<Integer, Integer> p1 = new Pair<>(v, w);
            Pair<Integer, Integer> p2 = new Pair<>(u, w);

            g.get(u).add(p1);
            g.get(v).add(p2);

        }
        return g;

    }

    public static void main(String[] args) {


        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(0);
        l1.add(4);
        l1.add(9);
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(4);
        l2.add(6);
        ArrayList<Integer> l3 = new ArrayList<>();
        l3.add(1);
        l3.add(2);
        l3.add(1);
        ArrayList<Integer> l4 = new ArrayList<>();
        l4.add(2);
        l4.add(5);
        l4.add(1);
        ArrayList<Integer> l5 = new ArrayList<>();
        l5.add(2);
        l5.add(4);
        l5.add(5);
        ArrayList<Integer> l6 = new ArrayList<>();
        l6.add(0);
        l6.add(3);
        l6.add(7);
        ArrayList<Integer> l7 = new ArrayList<>();
        l7.add(0);
        l7.add(1);
        l7.add(1);
        ArrayList<Integer> l8 = new ArrayList<>();
        l8.add(4);
        l8.add(5);
        l8.add(7);
        ArrayList<Integer> l9 = new ArrayList<>();
        l9.add(0);
        l9.add(5);
        l9.add(1);
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(l1);
        B.add(l2);
        B.add(l3);
        B.add(l4);
        B.add(l5);
        B.add(l6);
        B.add(l7);
        B.add(l8);
        B.add(l9);

        Solution_Djkstra sd = new Solution_Djkstra();
        int C = 4;
        int A = 6;
        System.out.println(sd.solve(A, B, C));

/*
  [0, 4, 9]
  [3, 4, 6]
  [1, 2, 1]

  [2, 5, 1]

  [2, 4, 5]

  [0, 3, 7]
  [0, 1, 1]

  [4, 5, 7]

  [0, 5, 1]
]*/


    }
}
