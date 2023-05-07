package isBST;

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

public class Valid_BST_Using_Range {

    public static int isValidBST(TreeNode A) {
        int start = Integer.MIN_VALUE;
        int end = Integer.MAX_VALUE;
        boolean valid = isValidBST_Helper(A, start, end);
        if (!valid) return 0;

        return 1;
    }

    public static boolean isValidBST_Helper(TreeNode root, int start, int end) {
        if (root == null) return true;

        if (root.val >= start && root.val <= end) {
            boolean left = isValidBST_Helper(root.left, start, root.val - 1);
            boolean right = isValidBST_Helper(root.right, root.val + 1, end);
            return left && right;
        }
        return false;
    }

    public static void main(String[] args) {
        //11 4 2 5 1 5 -1 -1 -1 -1 -1 -1
        TreeNode root= new TreeNode(11);
        System.out.println(isValidBST(root));
    }
}
