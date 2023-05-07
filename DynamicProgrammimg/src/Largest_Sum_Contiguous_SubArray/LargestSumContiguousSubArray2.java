package Largest_Sum_Contiguous_SubArray;

public class LargestSumContiguousSubArray2 {
    public int getMaxSum(int arr[]) {
        int n = arr.length;
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            int curSum = 0;
            for (int j = i; j < n; j++) {
                curSum += arr[j];
                if (curSum > maxSum) {
                    maxSum = curSum;
                }
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        LargestSumContiguousSubArray2 lcs2= new LargestSumContiguousSubArray2();
        int arr[]= {-2,11,-4,13,-5,2};
        System.out.println(lcs2.getMaxSum(arr));
    }
}
