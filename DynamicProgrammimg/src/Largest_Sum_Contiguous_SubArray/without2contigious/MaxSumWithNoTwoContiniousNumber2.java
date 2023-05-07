package Largest_Sum_Contiguous_SubArray.without2contigious;

public class MaxSumWithNoTwoContiniousNumber2 {
    public int getMaxSum(int arr[]){
        int n= arr.length;
        int [] dp= new int [n+1];
        dp[n-1] = arr[n-1];
        dp[n-2]= Math.max(arr[n-1],arr[n-2]);

        for(int i=n-2;i>=0; i--){
            dp[i]=Math.max(arr[i]+dp[i+2] ,dp[i+1]);
        }
        return dp[0];

    }

    public int getMaxSum2(int arr[]){
        int n= arr.length;
        int [] dp= new int [n];
        dp[0] = arr[0];
        dp[1]= Math.max(arr[0],arr[1]);

        for(int i=2;i<n; i++){
            dp[i]=Math.max(arr[i]+dp[i+2] ,dp[i+1]);
        }
        return dp[n-2];

    }

    public static void main(String[] args) {
        MaxSumWithNoTwoContiniousNumber2 lcs2= new MaxSumWithNoTwoContiniousNumber2();
         int arr[]= { 1, 2, 9, 4, 5, 0, 4, 11, 6 };
       // int arr[]= { 5, 20, 15, -2, 18};
        System.out.println(lcs2.getMaxSum(arr));
    }
}
