package Vertical_Order_Traversal;

import create.Node;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class VerticalOrderTraversal {
    public static  ArrayList<ArrayList<Integer>> verticalOrderTraversal(Node<Integer> root) {
        Queue<Pair<Node<Integer>, Integer>> q = new LinkedList<>();
        HashMap<Integer, ArrayList<Node<Integer>>> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> result= new ArrayList<>();
        q.add(new Pair<>(root, 0));
        int minLevel = 1;
        int maxLevel = -1;

        while (!q.isEmpty()) {
            Pair<Node<Integer>, Integer> f = q.remove();
            Node<Integer> node = f.getKey();
            Integer level = f.getValue();
            minLevel = Math.min(minLevel, level);  /// for traversing the map
            maxLevel = Math.max(maxLevel, level);  /// for traversing the map
//            ArrayList<Node<Integer>> l0 = new ArrayList<>();
//            l0.add(node);

            if(map.containsKey(level)){
                ArrayList<Node<Integer>> nodes = map.get(level);
                nodes.add(node);
                map.put(level,nodes);
            }else{
                ArrayList<Node<Integer>> l0 = new ArrayList<>();
                l0.add(node);
                map.put(level, l0);
            }


            if (node.left != null) {
                q.add(new Pair<>(node.left, level - 1));
            }

            if (node.right != null) {
                q.add(new Pair<>(node.right, level + 1));
            }

        }
        System.out.println(maxLevel +"--"+minLevel);
       // int j=0;
        for(int i=minLevel;i<=maxLevel;i++){
            ArrayList<Node<Integer>> nodes = map.get(i);
            ArrayList<Integer> tmp= new ArrayList<>();
            for (Node<Integer> node : nodes) {
                //System.out.print(node.data);
                tmp.add(node.data);
            }
            result.add(tmp);
           // System.out.println();
        }
        return result;
    }

    public static void main(String[] args) {

        /*
          1
        /    \
       2      3
      / \   /   \
     4   5  6   7
               /  \
              8   9

              4
              2
              1 5 6
              3 8
              7
              9
        * */
        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(3);
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(5);
        root.right.left = new Node<>(6);
        root.right.right = new Node<>(7);
        root.right.left.right = new Node<>(8);
        root.right.right.right = new Node<>(9);
        System.out.println("Vertical Order traversal is");
        System.out.println( verticalOrderTraversal(root));
    }
}
