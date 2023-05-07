package Climbing_Stairs;

///https://leetcode.com/problems/climbing-stairs/
public class ClimbingStairs_0Space {

    public static int climbStairs(int n) {
        if (n == 1) return 1;

        int var1 = 1;    /// to reach n from n we need 1 step
        int var2 = 2;   // to reach n from n-1 we need 1

        for (int i = 3; i <= n; i++) {
            int var3 = var1 + var2;
            var1 = var2;
            var2 = var3;
        }

        return var2;

    }

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

}
