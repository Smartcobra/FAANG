package coinchange;



public class MaximumCoinChange {
    public int getMaxWays(int arr[], int sum){
        int n= arr.length;
        int[][] dp = new int [n+1][sum+1];

        for(int i=0; i<=n;i++){
            dp[i][0]= 1;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-arr[i-1]];

                }
            }
        }//0cc93b3a
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int sum = 4;
        MaximumCoinChange ss = new MaximumCoinChange();
        System.out.println(ss.getMaxWays(arr, sum));
    }

}
