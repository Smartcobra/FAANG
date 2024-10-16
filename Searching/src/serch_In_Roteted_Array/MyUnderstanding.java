package serch_In_Roteted_Array;

public class MyUnderstanding {
    public int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;

        while (l <= h) {
            int mid = (l + h) / 2;

            if (nums[mid] == target) return mid;

            if (nums[mid] >= nums[l]) {  /// if arr[low] <= arr[mid]  , we are moving  left sorted array
                if (target >= nums[l] && target < nums[mid]) {  // checking if my target is in left sorted array
                    h = mid - 1;  // search restricted to low and move high to mid-1
                } else {
                    l = mid + 1;
                }
            } else {   /// right sorted array
                if (target > nums[mid] && target <= nums[h]) {   // target is between mid to high
                    l = mid + 1;   // change low
                } else {
                    h = mid - 1;
                }
            }
        }
        return -1;
    }
}
