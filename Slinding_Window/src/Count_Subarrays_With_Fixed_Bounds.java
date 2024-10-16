public class Count_Subarrays_With_Fixed_Bounds {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int c_i = -1;
        int min_i = -1;
        int max_i = -1;
        long ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                c_i = i;
            }

            if (nums[i] == minK) {
                min_i = i;
            }

            if (nums[i] == maxK) {
                max_i = i;
            }

            long validStart = Math.min(min_i, max_i);
            long tmp = validStart - c_i;

            ans += tmp <= 0 ? 0 : tmp;
        }

        return ans;

    }
}
