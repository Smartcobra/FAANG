package Minimum_Size_Subarray_Sum;
//https://leetcode.com/problems/minimum-size-subarray-sum/
public class Minimum_Size_Subarray_Sum_BF {

    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum = sum + nums[k];
                }
                if (sum >= target) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans!=Integer.MAX_VALUE?ans:0;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7,arr));

        int[] arr2 = {1,1,1,1,1,1,1,1};
        System.out.println(minSubArrayLen(11,arr2));

    }
}
