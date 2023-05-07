package allAncestors;

import create.Node;

/*
*
Given a Binary Tree and a key, write a function that prints all the ancestors of the key in the given binary tree.
For example, if the given tree is following Binary Tree and key is 7, then your function should print 4, 2 and 1.


              1
            /   \
          2      3
        /  \
      4     5
     /
    7

* */
public class PrintAllAncestor {
    public static boolean printAllAncestor(Node<Integer> root, int data){
        if( root==null){
            return false;
        }

        if( root.data==data){
            return true;
        }

        if(printAllAncestor(root.right,data) || printAllAncestor(root.left,data)){
            System.out.println(root.data);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        /* Construct the following binary tree
                  1
                /   \
               2     3
              /  \
             4    5
            /
           7
        */
        Node<Integer> root= new Node<>();
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(7);

        printAllAncestor(root,7);
    }
}
