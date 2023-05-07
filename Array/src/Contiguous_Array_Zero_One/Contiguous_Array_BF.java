package Contiguous_Array_Zero_One;

public class Contiguous_Array_BF {
    // https://leetcode.com/problems/contiguous-array/


    public static int findMaxLength(int[] nums) {
        int n = nums.length;
        int maxlen = 0;

        for (int i = 0; i < n; i++) {
            int ones = 0;
            int zeros = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] == 0) {
                    zeros++;
                } else {
                    ones++;
                }
                if (zeros == ones) {
                    maxlen = Math.max(maxlen, j - i + 1);
                }
            }
        }
        return maxlen;

    }

    public static void main(String[] args) {
       int []nums= {0,1,0,1,0,1,1,1};
        System.out.println(findMaxLength(nums));
    }
}
