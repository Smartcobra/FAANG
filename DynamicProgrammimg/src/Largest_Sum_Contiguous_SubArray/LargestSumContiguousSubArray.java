package Largest_Sum_Contiguous_SubArray;

public class LargestSumContiguousSubArray {
    public int getMaxSum(int arr[]){

        int maxSum=0;
        for(int i=0; i< arr.length;i++){
            for(int j=i;j<arr.length; j++){
                int curSum=0;
                for(int k=i;k<=j;k++){
                    curSum +=arr[k];
                }
                if(curSum>maxSum){
                    maxSum=curSum;
                }

            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        LargestSumContiguousSubArray lc= new LargestSumContiguousSubArray();
        int arr[]= {-2,11,-4,13,-5,2};
        System.out.println(lc.getMaxSum(arr));
    }
}
