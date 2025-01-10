package Count_Array_Pairs_Divisible_By_K;

import java.util.HashMap;
//https://leetcode.com/problems/single-number/description/
public class Solution {
    public static long countPairs(int[] nums, int k) {
        HashMap<Integer, Integer> gcdCount = new HashMap<>();
        long pairCount = 0;

        for (int num : nums) {
            int gcdNum = gcd(num, k);
            for (int gcdKey : gcdCount.keySet()) {
                if ((long) gcdNum * gcdKey % k == 0) { //For every number, check if the product of its GCD with the keys in the hashmap is divisible by KK.
                    pairCount += gcdCount.get(gcdKey);
                }
            }
            gcdCount.put(gcdNum, gcdCount.getOrDefault(gcdNum, 0) + 1);
        }

        return pairCount;
    }

    // Helper method to calculate GCD
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
//O(n⋅log(K))
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int k = 2;

        long result = countPairs(nums, k);
        System.out.println("Number of pairs divisible by " + k + ": " + result);
    }
}
