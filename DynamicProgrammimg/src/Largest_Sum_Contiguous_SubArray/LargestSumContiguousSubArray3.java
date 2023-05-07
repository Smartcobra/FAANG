package Largest_Sum_Contiguous_SubArray;

public class LargestSumContiguousSubArray3 {
    public int getMaxSum(int arr[]){
        int sum=0;
        int maxSum=arr[0];

        for(int i=0;i<arr.length; i++){
            sum=Math.max(sum+arr[i],arr[i]);
            maxSum= Math.max(sum,maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        LargestSumContiguousSubArray3 lcs2= new LargestSumContiguousSubArray3();
        int arr[]= {-2,11,-4,13,-5,2};
        System.out.println(lcs2.getMaxSum(arr));
    }
}
