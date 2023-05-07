package Longest_Consecutive_Sequence;

public class Longest_Consecutive_Sequence {
    public static int longestConsecutive(final int[] A) {
        int n = A.length;

        int longest_length = 0;

        for (int a : A) {
            int curr_Length = 1;
            int curr_element = a;
            while (searchNext(A, curr_element + 1)) {
                curr_Length += 1;
                curr_element += 1;

            }
            longest_length = Math.max(longest_length, curr_Length);
        }
        return longest_length;

    }

    private static boolean searchNext(int[] A, int num) {
        for (int a : A) {
            if (a == num) {
                return true;
            }
        }
         return false;
    }

    public static void main(String[] args) {
       int [] A = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(A));
    }

}
