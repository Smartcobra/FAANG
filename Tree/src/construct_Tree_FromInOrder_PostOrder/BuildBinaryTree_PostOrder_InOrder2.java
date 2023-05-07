package construct_Tree_FromInOrder_PostOrder;

import create.Node;

public class BuildBinaryTree_PostOrder_InOrder2 {
    public static Node<Integer> buildBinaryTree(int[] postOrder, int[] inOrder) {
        if (postOrder.length == 0 || postOrder.length != inOrder.length) {
            return null;
        }

        int psi = 0;
        int pei = postOrder.length - 1;
        int isi = 0;
        int iei = inOrder.length - 1;
        return buildBinaryTree(postOrder, psi, pei, inOrder, isi, iei);

    }

    private static Node<Integer> buildBinaryTree(int[] postOrder, int psi, int pei, int[] inOrder, int isi, int iei) {
        if (psi > pei || isi > iei) {
            return null;
        }
        int idx = isi;
        while (inOrder[idx] != postOrder[pei]) {
            idx++;
        }
        //count of element left subtree in inorder
        int cols = idx - isi;

        int data = postOrder[pei];
        Node<Integer> node = new Node<>(data);

        node.left = buildBinaryTree(postOrder, psi, psi + cols - 1, inOrder, isi, idx - 1);
        node.right = buildBinaryTree(postOrder, psi + cols, pei - 1, inOrder, idx + 1, iei);

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

    public static void postOrderTraversal(Node<Integer> root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + "->");

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

        int[] inorder = {4, 2, 1, 7, 5, 8, 3, 6};
        int[] postorder = {4, 2, 7, 8, 5, 6, 3, 1};

        Node root = buildBinaryTree(postorder, inorder);

        // traverse the constructed tree
        System.out.print("Inorder traversal is ");
        inOrderTraversal(root);
        System.out.print("\nPostorder traversal is ");
        postOrderTraversal(root);
    }
}
