package Maximum_Subarray;
////But the catch here is that if at any point sum becomes negative then
// no point keeping it because 0 is obviously greater than negative, so just make your sum 0.

//https://leetcode.com/problems/maximum-subarray/solution/
public class Kadens2 {
    public int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : nums) {
            sum += num;
            max = Math.max(sum, max);
            sum = Math.max(sum, 0);
        }

        return max;

    }

}
