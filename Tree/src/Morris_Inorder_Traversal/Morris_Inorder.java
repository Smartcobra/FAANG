package Morris_Inorder_Traversal;

import create.CreateTree;
import create.Node;

import java.util.ArrayList;



public class Morris_Inorder {
    public static ArrayList<Integer> inorder( Node<Integer> root) {
        ArrayList<Integer> result = new ArrayList<>();
        Node<Integer> curr = root;

        while (curr != null) {
            if (curr.left == null) {
                result.add(curr.data);
                curr = curr.right;
            } else {
                Node<Integer> prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    result.add(curr.data);
                    curr = curr.right;
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        Node<Integer> node = CreateTree.buildTree();
        System.out.println(inorder(node));

    //    2->7->5->6->11->11->5->4->9->

    }
}
