package GoogleInterviewQuestion1;

/*
* Given an integer array a, and 2 integers - c and k, where c is the favourite number and k is the maximum number of replacements we can make. We have to find the maximum number of contiguous elements which are equal to c. We can replace k number of elements with any number we want.

Example - a = [1,2,2,3,2,2,2,4], c=2, k=2.

    In this case, without any replacement, maximum number of contiguous elements will be 3 (from index 4 to index 6).
    We can replace element at index 3 with number 2 so now array will be a = [1,2,2,2,2,2,2,4] , maximum number of contiguous elements will be 6 (from index 1 to index 6).
    For last replacement, we can replace either element at index 0 or index 7 with number 2, so maximum number of contiguous elements will be 7, which is the answer..

*
* */

public class Solution {

    public static int func(int[] nums, int k, int c) {
        int left = 0, right;
        for (right = 0; right < nums.length; right++) {
            // If we included 'c' in the window we reduce the value of k.
            // Since k is the maximum c's allowed in a window.
            if (nums[right] != c) {
                k--;
            }
            // A negative k denotes we have consumed all allowed flips and window has
            // more than allowed c's, thus increment left pointer by 1 to keep the window size same.
            if (k < 0) {
                // If the left element to be thrown out is zero we increase k.
                if (nums[left] != c) {
                    k++;
                }
                left++;
            }
        }
        return right - left;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] nums_1 = new int[]{1,2,2,3,3,2,2,2,4};//5
        int[] nums_2 = new int[]{1,2,2,3,2,2,2,4,2,2,3,3,3,2,2,2,2,2,2};

        System.out.println(func(nums_1, 2, 2)); ///7
        System.out.println(func(nums_2, 3, 2)); ///11
    }
}
