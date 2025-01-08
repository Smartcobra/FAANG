package SubArray_Sum_Equal_to_Given_Sum_Return_Index;

/*
 * Given an unsorted array arr of non negative integers and an integer sum,
 * find a continuous subarray which adds to a given sum. There may be more than one subarrays with sum as the given sum, print first such subarray.
 * */

public class Solution {
    public static void findSubArray(int[] arr, int target) {
        int n = arr.length;
        int sum;
        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];

                if (sum == target) {
                    System.out.println(i + "-" + j);
                }

            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {15, 2, 4, 8, 9, 5, 10, 23, 12};
        int n = arr.length;
        int sum = 23;
        findSubArray(arr, sum);

    }
}
