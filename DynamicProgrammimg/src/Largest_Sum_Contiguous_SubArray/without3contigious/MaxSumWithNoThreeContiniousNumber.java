package Largest_Sum_Contiguous_SubArray.without3contigious;

public class MaxSumWithNoThreeContiniousNumber {

    public int maxSumWO3Consec(int arr[]){
        int n=arr.length;
        int dp[]= new int [n];
        if(n>=1){
            dp[0]= arr[0];
        }

        if(n>=2){
            dp[1]= arr[0]+arr[1];
        }
        if(n>2){
            dp[2] =Math.max(dp[1],Math.max(arr[1]+arr[2],arr[0]+arr[2]));
        }
        for(int i=3;i<n;i++){
            dp[i]=Math.max(arr[i]+arr[i-1]+dp[i-3],Math.max(dp[i-1],dp[i-2]+arr[i]));
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        MaxSumWithNoThreeContiniousNumber ms= new MaxSumWithNoThreeContiniousNumber();
        int arr[] = { 100, 1000, 100, 1000, 1 };
        System.out.println(ms.maxSumWO3Consec(arr));
    }
}
