package Search_Insert_Position;
//https://leetcode.com/problems/search-insert-position/submissions/
public class Solution {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++)

            // If K is found
            if (nums[i] == target)
                return i;

                // If current array element
                // exceeds K
            else if (nums[i] > target)
                return i;

        // If all elements are smaller
        // than K
        return nums.length;
    }
}
