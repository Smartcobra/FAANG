package serch_In_Roteted_Array;

public class ImprovedSolution {
    public static  int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;

        while (l <= h) {
            int mid = (l + h) / 2;

            if (nums[mid] == target) return mid;

            if (nums[mid] >= nums[l]) {
                if (target > nums[mid] || target < nums[l]) {
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }
            } else {
                if (target < nums[mid] || target > nums[h]) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] A={23,27,28,4,5,6,7,8,9,10,11};
        int B=27;
        System.out.println(search(A, B));
    }
}
