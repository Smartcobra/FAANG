package Odd_And_Even_Levels;

public class OddAndEvenLevels_Recursion {

    public int solve(TreeNode A) {
        if (A == null) return 0;

        return A.val - solve(A.left) - solve(A.right);
    }

}
