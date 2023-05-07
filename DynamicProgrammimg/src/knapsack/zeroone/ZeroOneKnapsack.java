package knapsack.zeroone;

public class ZeroOneKnapsack {

    /*public static int knapsack(int wt[],int val[], int W, int n){
        int i=0;
        int w=0;

        int dp[][] = new int [n+1][W+1];

        for( i=0;i<n+1;i++){
            for(w=0;w<W+1;w++){
                if(i==0 || w==0){
                    dp[i][w]=0;
                }
            }
        }

        for( i=1;i<n+1;i++){
            for(w=1;w<W+1;w++){

                if(wt[i-1] <=w){
                   dp[i][w]= Math.max(val[i-1]+dp[i-1] [ w - wt[i-1] ], dp[i-1][w]);
                }else{
                    dp[i][w]=dp[i-1][w];
                }
            }
        }
   return dp[n][W];*/

        ////////////////-----With -------------//
        public static int knapsack(int wt[],int val[], int W, int n){
            int i=0;
            int w=0;

            int[][] dp = new int [n+1][W+1];

            for( i=0;i<n+1;i++){
                for(w=0;w<W+1;w++){
                    if(i==0 || w==0){
                        dp[i][w]=0;
                    }
                }
            }

            for( i=0;i<n+1;i++){
                for(w=0;w<W+1;w++){
                    if(i==0 || w==0) {
                        dp[i][w] = 0;
                    }
                    else if(wt[i-1] <=w){
                        dp[i][w]= Math.max(val[i-1]+dp[i-1] [ w - wt[i-1] ], dp[i-1][w]);
                    }else{
                        dp[i][w]=dp[i-1][w];
                    }
                }
            }
            return dp[n][W];
    }

    public static void main(String[] args) {
        int[] val = new int[] { 60, 100, 120 };
        int[] wt = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println(knapsack(wt,val,W,n));
    }
}




