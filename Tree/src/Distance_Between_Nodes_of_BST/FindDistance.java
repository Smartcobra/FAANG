package Distance_Between_Nodes_of_BST;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class FindDistance {
    public int getDist(TreeNode root, int k, int dist) {
        if (root == null) return -1;

        if (root.val == k) return dist;

        int left = getDist(root.left, k, dist + 1);
        if (left != -1) {
            return left;
        }

        return getDist(root.right, k, dist + 1);
    }

    public TreeNode LCA(TreeNode root, int n1, int n2) {
        if (root == null) return null;
        if (root.val == n1 || root.val == n2) return root;

        TreeNode left = LCA(root.left, n1, n2);
        TreeNode right = LCA(root.right, n1, n2);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }

    public int findDistance(TreeNode root, int n1, int n2) {
        TreeNode lca = LCA(root, n1, n2);
        int d1 = getDist(lca, n1, 0);
        int d2 = getDist(lca, n2, 0);
        return d1 + d2;
    }

}
