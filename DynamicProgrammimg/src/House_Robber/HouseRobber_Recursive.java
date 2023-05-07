package House_Robber;

////https://leetcode.com/problems/house-robber/

/*
 *
 *    f(n)= max( nums[0]+f(n-2) ,f(n-1) );
 *
 * */
public class HouseRobber_Recursive {

    public static int rob(int[] nums) {
        int n = nums.length;
        return rob_helper(nums, n);

    }

    public static int rob_helper(int[] nums, int n) {
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        return Math.max(rob_helper(nums, n - 1), rob_helper(nums, n - 2) + nums[n - 1]);

    }

    public static void main(String[] args) {
        int [] nums={1,2,3,1};
        System.out.println(rob(nums));
    }

}
