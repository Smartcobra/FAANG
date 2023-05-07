public class BinarySearch {

    public static  int search(int[] nums, int target) {
        int n = nums.length;
        int k = pivot(nums);
        int ans = -1;
        if( k !=0 && target > nums[k-1]) return ans;

        if (nums[0] <= nums[n - 1]) {
            ans = binarySearc(nums, target, 0, n - 1);
        } else if (target < nums[0]) {
            ans = binarySearc(nums, target, k, n - 1);
        } else {
            ans = binarySearc(nums, target, 0, k - 1);
        }

        return ans;
    }


    public static int binarySearc(int[] nums, int target, int start, int end) {

        int l = start;
        int h = end;

        while (l <= h) {
            int mid = (l + h) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return -1;
    }


    public static int pivot(int[] nums) {
        int h = nums.length - 1;
        int l = 0;
        int pivot = 0;

        while (l <= h) {
            int mid = (l + h) / 2;

            if (nums[mid] < nums[0]) {
                pivot = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return pivot;
    }

    public static  void main(String[] args) {
       // int[] A={4, 5, 6, 7, 0, 1, 2};
        int[] A={1};
        int B=1;
        System.out.println(search(A,B));
    }

}
