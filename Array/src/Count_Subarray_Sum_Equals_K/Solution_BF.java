package Count_Subarray_Sum_Equals_K;

public class Solution_BF {
    public static int subarraySum(int[] arr, int target) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum = sum + arr[k];
                    if (sum == target) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int [] arr={1,2,3};
        System.out.println(subarraySum(arr,3));
    }
}
