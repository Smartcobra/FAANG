package Top_View_of_Binary_Tree;

import create.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Pair<K, V> {
    K key;
    V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

}

public class TopViewOfBinaryTree {
    public static  ArrayList<Integer> topView(Node<Integer> root) {
        HashMap<Integer, ArrayList<Node<Integer>>> map = new HashMap<>();
        Queue<Pair<Node<Integer>, Integer>> q = new LinkedList<>();
        ArrayList<Integer> output = new ArrayList<>();
        q.add(new Pair<>(root, 0));
        int minLevel = 1;
        int maxLevel = -1;

        while (!q.isEmpty()) {
            Pair<Node<Integer>, Integer> f = q.remove();
            Node<Integer> node = f.getKey();
            int level = f.getValue();
            minLevel = Math.min(minLevel, level);
            maxLevel = Math.max(maxLevel, level);

            if (map.containsKey(level)) {
                ArrayList<Node<Integer>> nodes = map.get(level);
                nodes.add(node);
                map.put(level, nodes);
            } else {
                ArrayList<Node<Integer>> l = new ArrayList<>();
                l.add(node);
                map.put(level, l);
            }

            if (node.left != null) {
                q.add(new Pair<>(node.left, level - 1));
            }

            if (node.right != null) {
                q.add(new Pair<>(node.right, level + 1));
            }
        }
      //  System.out.println(map);
        //ArrayList<ArrayList<Integer>> result= new ArrayList<>();
        output.add(root.data);
         for(int i=-1;i>=minLevel;i--){
             ArrayList<Node<Integer>> tmp=map.get(i);
             output.add(tmp.get(0).data);
         }

        for(int i=1;i<=maxLevel;i++){
            ArrayList<Node<Integer>> tmp=map.get(i);
            output.add(tmp.get(0).data);
        }
        System.out.println(output);

        return output;

    }

    public static void main(String[] args) {
        /*
        *   1
          /   \
         2    3
        / \  / \
       4   5 6  7
      /
     8
     * */

        // [1, 2, 4, 8, 3, 7]

        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(3);
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(5);
        root.right.left = new Node<>(6);
        root.right.right = new Node<>(7);
        root.left.left.left = new Node<>(8);
        System.out.println("Vertical Order traversal is");
        System.out.println( topView(root));
    }

}
