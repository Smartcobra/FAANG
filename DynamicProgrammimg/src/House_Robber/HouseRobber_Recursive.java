package House_Robber;

////https://leetcode.com/problems/house-robber/

/*
 *
 *    f(n)= max( nums[0]+f(n-2) ,f(n-1) );
 *
 * */
public class HouseRobber_Recursive {

    public static int rob(int[] nums) {
        return rob_helper(nums, 0);

    }

    public static int rob_helper(int[] nums, int n) {
        if (n >= nums.length) return 0;
        int steal = nums[n]+rob_helper(nums,n+2);
        int skip = rob_helper(nums,n+1);
        return Math.max(steal,skip);

    }

    public static void main(String[] args) {
        int [] nums={1,2,3,1};
        System.out.println(rob(nums));
    }

}
