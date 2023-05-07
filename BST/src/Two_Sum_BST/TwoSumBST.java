package Two_Sum_BST;


import java.util.HashSet;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }

    public static class TwoSumBST {

        public int t2Sum(TreeNode A, int B) {
            HashSet<Integer> set = new HashSet<>();
            boolean f = t2Sum_Helper(A, B, set);
            return f ? 1 : 0;
        }


        public boolean t2Sum_Helper(TreeNode A, int B, HashSet<Integer> set) {
            if (A == null) return false;
            if (set.contains(B - A.val)) return true;
            set.add(A.val);
            return t2Sum_Helper(A.left, B, set) || t2Sum_Helper(A.right, B, set);

        }
    }
}