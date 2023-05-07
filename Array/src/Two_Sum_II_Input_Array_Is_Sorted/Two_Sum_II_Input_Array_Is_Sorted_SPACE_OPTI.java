package Two_Sum_II_Input_Array_Is_Sorted;

public class Two_Sum_II_Input_Array_Is_Sorted_SPACE_OPTI {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int low = 0;
        int high = n - 1;

        while (low < high) {
            int cur_sum = numbers[low] + numbers[high];
            if (cur_sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (cur_sum > target) {
                high--;
            } else {
                low++;
            }
        }


        return new int[]{-1, -1};
    }
}
