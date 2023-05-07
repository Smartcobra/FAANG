package Next_Pointer_Binary_Tree;

public class NextPointerBinaryTree_Iterative {
    public static void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode cur = root;
        TreeLinkNode nxt = root.left;   ///holds the root.left;

        while ( nxt != null) {
            cur.left.next = cur.right;

            if (cur.next != null) {
                cur.right.next = cur.next.left;
            }
            cur = cur.next;
            if (cur == null) {   // if null move to next level
                cur = nxt;
                nxt = cur.left;
            }
        }

    }

    public static void main(String[] args) {
        TreeLinkNode root= new TreeLinkNode(1);
        root.left= new TreeLinkNode(2);
        root.right= new TreeLinkNode(3);
        root.left.right= new TreeLinkNode(5);
        root.left.left= new TreeLinkNode(9);
        root.right.left= new TreeLinkNode(6);
        root.right.right= new TreeLinkNode(5);

        connect(root);
    }
}
