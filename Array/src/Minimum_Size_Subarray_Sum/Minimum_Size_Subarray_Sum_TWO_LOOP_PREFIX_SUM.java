package Minimum_Size_Subarray_Sum;

//https://leetcode.com/problems/minimum-size-subarray-sum/
//https://www.youtube.com/watch?v=b7wMv62Y1l4
public class Minimum_Size_Subarray_Sum_TWO_LOOP_PREFIX_SUM {
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;

        int[] psa = new int[n];

        //populate prefix sum array
        psa[0] = nums[0];
        for (int i = 1; i < n; i++) {
            psa[i] = psa[i - 1] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            int sum=0;
            for (int j = i; j < n; j++) {
            //    int sum = psa[j] - psa[i] + nums[i];   /// actual sum between i to j + number present at input array
                 sum = psa[j] - psa[i] + nums[i];
                if (sum >= target) {
                    ans = Math.min(ans, j - i + 1);
                }
            }
        }
        return (ans != Integer.MAX_VALUE)? ans: 0;

    }

    public static void main(String[] args) {
            int[] arr = {2, 3, 1, 2, 4, 3};
            System.out.println(minSubArrayLen(7,arr));

            int[] arr2 = {1,1,1,1,1,1,1,1};
            System.out.println(minSubArrayLen(11,arr2));
    }
}
