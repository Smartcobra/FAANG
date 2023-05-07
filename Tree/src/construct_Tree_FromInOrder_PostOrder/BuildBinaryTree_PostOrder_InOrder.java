package construct_Tree_FromInOrder_PostOrder;

import create.Node;

class Index {
    int index;
}

public class BuildBinaryTree_PostOrder_InOrder {
    public static Node<Integer> buildBinaryTree(int[] postOrder, int[] inOrder) {
        if (postOrder.length == 0 || postOrder.length != inOrder.length) {
            return null;
        }
        Index index = new Index();
        index.index = postOrder.length - 1;
        return buildBinaryTree(postOrder, inOrder, 0, inOrder.length - 1, index);

    }

    private static Node<Integer> buildBinaryTree(int[] postOrder, int[] inOrder, int inStart, int inEnd, Index index) {
        // int idx =poEnd;
        //base condition
        if (inStart > inEnd) {
            return null;
        }

        int val = postOrder[index.index];
        Node<Integer> curr = new Node<>(val);
        index.index--;
        ///inStart is the start of inOrder and inEnd is the end of the inOrder.
        //if start==end then only one element is there ie. we dont have left and right subtree.
        if (inStart == inEnd) {
            return curr;
        }
        //serch the element in the [] inOrder
        int pos = search(inOrder, inStart, inEnd, val);
        curr.right = buildBinaryTree(postOrder, inOrder, pos + 1, inEnd, index);
        curr.left = buildBinaryTree(postOrder, inOrder, inStart, pos - 1, index);

        return curr;
    }

    private static int search(int[] inOrder, int inStart, int inEnd, int val) {
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == val) {
                return i;
            }
        }

        return -1;
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
        //  System.out.print("\nPostorder traversal is "); postOrderTraversal(root);
    }
}
