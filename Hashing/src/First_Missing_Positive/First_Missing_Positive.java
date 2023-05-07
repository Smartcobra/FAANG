package First_Missing_Positive;

public class First_Missing_Positive {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            while (nums[i] != i + 1) {

                if (nums[i] <= 0 || nums[i] >= n) break;

                if (nums[i] == nums[nums[i] - 1]) break;

                int tmp = nums[i];
                nums[i] = nums[tmp - 1];
                nums[tmp - 1] = tmp;

            }
        }
//This problem only considers positive numbers, so we need to shift 1 offset. The ith element is i+1.
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }


        return n + 1;

    }
}
