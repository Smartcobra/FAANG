package construct_Tree_FromInOrder_PostOrder;

import create.Node;


public class BuildBinaryTree_PostOrder_InOrder3 {
    public static int idx;

    public static Node buildTree(int[] in, int[] post) {
        int in_start = 0;
        int in_end = in.length - 1;
         idx = post.length - 1;

        return buildTree_Helper(in, post, in_start, in_end);

    }

    public static  Node buildTree_Helper(int[] in, int[] post, int in_start, int in_end) {

        if (in_start > in_end) return null;

        int val = post[idx];
        Node curr = new Node(val);
        idx--;

        if (in_start == in_end) return curr;

        int pos = search(in, val);

        curr.right = buildTree_Helper(in, post, pos + 1, in_end);
        curr.left = buildTree_Helper(in, post, in_start, pos - 1);

        return curr;

    }


    private static int search(int[] in, int val) {
        for (int i = 0; i <= in.length- 1; i++) {
            if (in[i] == val) {
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

        Node root = buildTree(postorder, inorder);

        // traverse the constructed tree
        System.out.print("Inorder traversal is ");
        inOrderTraversal(root);
        //  System.out.print("\nPostorder traversal is "); postOrderTraversal(root);
    }
}
