package Find_First_and_Last_Position_of_Element_in_Sorted_Array;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class Find_First_and_Last_Position_of_Element_in_Sorted_Array {

    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int l = 0;
        int h = nums.length - 1;

        ///// /////  first index
        while (l <= h) {
            int mid = (l + h) / 2;
            if (nums[mid] == target) {
                ans[0] = mid;
                ///searh more towards left for first index
                h = mid - 1;
            } else if (nums[mid] < target) {   // traget is right side , move low to mid+1
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }


        /////  second index
        l = 0;
        h = nums.length - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (nums[mid] == target) {
                ans[1] = mid;
                ///searh more towards left for first index
                l = mid + 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        return ans;

    }


}
