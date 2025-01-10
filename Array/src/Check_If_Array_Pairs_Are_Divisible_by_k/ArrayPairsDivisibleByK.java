package Check_If_Array_Pairs_Are_Divisible_by_k;

import java.util.HashMap;
//https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/description/
public class ArrayPairsDivisibleByK {
    public static boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> remainderMap = new HashMap<>();

        // Count the remainders
        for (int num : arr) {
            int remainder = ((num % k) + k) % k; // Handle negative numbers
            remainderMap.put(remainder, remainderMap.getOrDefault(remainder, 0) + 1);
        }

        // Check pairing conditions
        for (int remainder : remainderMap.keySet()) {
            int freq = remainderMap.get(remainder);

            if (remainder == 0) {
                // Remainder 0 must have an even count
                if (freq % 2 != 0) {
                    return false;
                }
            } else {
                int complement = k - remainder;

                // Remainder `remainder` must pair with `complement`
                if (!remainderMap.containsKey(complement) || remainderMap.get(complement) != freq) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 10, 6, 7, 8, 9};
        int k = 5;

        boolean result = canArrange(arr, k);
        System.out.println("Can the array be paired? " + result);
    }
}
