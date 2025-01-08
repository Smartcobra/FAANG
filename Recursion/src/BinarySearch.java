public class BinarySearch {
    public int search(int[] nums, int target) {

        return searchHelper(nums, target, 0, nums.length - 1);

    }

    public int searchHelper(int[] nums, int target, int start, int end) {

        if (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == nums[mid]) {
                return mid;
            } else if (nums[mid] <= target) {
                return searchHelper(nums, target, mid + 1, end);
            } else {
                return searchHelper(nums, target, start, mid - 1);
            }
        } else {
            return -1;
        }

    }
}
