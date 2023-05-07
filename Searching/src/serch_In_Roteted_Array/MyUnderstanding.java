package serch_In_Roteted_Array;

public class MyUnderstanding {
    public int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;

        while (l <= h) {
            int mid = (l + h) / 2;

            if (nums[mid] == target) return mid;

            if (nums[mid] >= nums[l]) {  /// low to mid array is sorted
                if (target >= nums[l] && target < nums[mid]) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {   /// mid to high sorted
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
