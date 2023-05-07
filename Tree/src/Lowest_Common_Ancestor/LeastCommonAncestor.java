package Lowest_Common_Ancestor;

import create.Node;

public class LeastCommonAncestor {
    public static Node<Integer> LCA = null;

    public static Node<Integer> findLCA(Node<Integer> root, int p, int q) {
        findLCA_(root, p, q);
        return LCA;
    }

    private static boolean findLCA_(Node<Integer> root, int p, int q) {
        if (root == null) {
            return false;
        }
        //self
        boolean self = root.data == p || root.data == q;
        //left
        boolean left = findLCA_(root.left, p, q);
        //to stop recursion if we got the LCA already
        if (LCA != null) {
            return true;
        }
        //right
        boolean right = findLCA_(root.right, p, q);
        //to stop recursion if we got the LCA already
        if (LCA != null) {
            return true;
        }

        if ((left && self) || (left && right) || (right && self)) {
            LCA = root;
        }
        /// if any one is true
        return self || left || right;
    }

    public static void main(String[] args) {
         /* Construct the following tree
              1
            /   \
           /     \
          2       3
           \     / \
            4   5   6
               / \
              7   8
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        Node lca = findLCA(root, 6, 7);
        System.out.println(lca.data);
    }
}
