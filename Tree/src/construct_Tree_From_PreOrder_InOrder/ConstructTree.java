package construct_Tree_From_PreOrder_InOrder;

import create.Node;

public class ConstructTree {
    public static Node<Integer> constructTree(int[] preOrder, int[] inOrder) {
        if (preOrder.length != inOrder.length || preOrder.length == 0) {
            return null;
        }
        int psi = 0;
        int pei = preOrder.length - 1;
        int isi = 0;
        int iei = inOrder.length - 1;
        Node<Integer> root = constructTree(preOrder, psi, pei, inOrder, isi, iei);
        return root;
    }

    private static Node<Integer> constructTree(int[] preOrder, int psi, int pei, int[] inOrder, int isi, int iei) {

        if (psi > pei || isi > iei) {
            return null;
        }

       ///finding number of elements in the leftsubTree from inOrder[]
        int idx = isi;
        while (inOrder[idx] != preOrder[psi]) {
            idx++;
        }
        int colstree=idx-isi;  //count of element in the left subtree

        int data = preOrder[psi];
        Node<Integer> node = new Node<Integer>(data);

        node.left=constructTree(preOrder,psi+1,psi+colstree,inOrder,isi,idx-1);
        node.right=constructTree(preOrder,psi+colstree+1,pei,inOrder,idx+1,iei);
        return node;
    }
    public static void inOrderTraversal(Node<Integer> root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data + "->");
        inOrderTraversal(root.right);
    }

    public static void preOrderTraversal(Node<Integer> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + "->");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);


    }

    public static void main(String[] args) {
        /* Construct the following tree
                   1
                 /   \
                /     \
               2       3
              /       / \
             /       /   \
            4       5     6
                   / \
                  /   \
                 7     8
        */

        int[] inorder = { 4, 2, 1, 7, 5, 8, 3, 6 };
        int[] preorder = { 1, 2, 4, 3, 5, 7, 8, 6 };

        Node root = constructTree(preorder,inorder );

        // traverse the constructed tree
        System.out.print("The inorder traversal is ");
        inOrderTraversal(root);

        System.out.print("\nThe preorder traversal is ");
        preOrderTraversal(root);
    }
}
