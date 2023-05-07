package Sub_Array_Sum_Equal_to_Given_Sum;

public class Solution2 {

    public static void findSubArray(int[] arr, int target) {

        int start = 0;
        int end = 0;
        int window_sum = 0;

        while (end < arr.length) {
            window_sum += arr[end];

            if (window_sum == target) {
                System.out.println(start + " " + end);
               // return;
            }

            while (window_sum > target && start <= end) {
                window_sum = window_sum - arr[start++];
                //start++;
                if (window_sum == target) {
                    System.out.println(start + " " + end);
                   // return;
                }
            }
            end++;
        }

    }

    public static void main(String[] args) {
        int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
        int sum = 23;
        findSubArray(arr,sum);
    }
}
