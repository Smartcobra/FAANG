package Largest_Sum_Contiguous_SubArray.without2contigious;



public class MaxSumWithNoTwoContiniousNumber {

    public int getSum(int arr[]){
        int n= arr.length;
        int dp[]= new int[n];
        dp[0]=arr[0];
        dp[1]= Math.max(arr[0],arr[1]);

        for(int i=2; i<n;i++){
            dp[i]= Math.max(arr[i]+dp[i-2],dp[i-1]);
        }
        return dp[n-1];

    }

    public static void main(String[] args) {
        MaxSumWithNoTwoContiniousNumber lcs2= new MaxSumWithNoTwoContiniousNumber();
       // int arr[]= { 1, 2, 9, 4, 5, 0, 4, 11, 6 };
        int arr[]= { 5, 20, 15, -2, 18};
        System.out.println(lcs2.getSum(arr));
    }
}
