package Longest_Consecutive_Sequence;

import java.util.HashSet;
import java.util.Set;
///https://leetcode.com/problems/longest-consecutive-sequence/
public class Solution_HAshSet {
    public static int longestConsecutive(final int[] A) {
        int longestSequence = 0;
        Set<Integer> set = new HashSet<>();

        for (int a : A) {
            set.add(a);
        }

        for (int a : set) {
            if (!set.contains(a - 1)) {
                int cur_a = a;
                int cur_l = 1;

                while (set.contains(cur_a+ 1)) {
                    cur_a += 1;
                    cur_l += 1;
                }
                longestSequence = Math.max(longestSequence, cur_l);
            }

        }

        return longestSequence;

    }

    public static void main(String[] args) {
        int[] A = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(A));
    }
}
