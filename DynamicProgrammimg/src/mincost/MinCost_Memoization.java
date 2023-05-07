package mincost;

public class MinCost_Memoization {

    public static int getMinCostM( int cost[][] , int i ,int j,int dp[][]){
        int m=cost.length;
        int n= cost[0].length;

        if( i==m-1 && j==n-1){
            return cost[i][j];
        }
        if(i>=m || j>=n){
            return Integer.MAX_VALUE;
        }
        int ans1,ans2,ans3;
        if(dp[i+1][j] == Integer.MAX_VALUE){
            ans1=getMinCostM(cost, i+1,j,dp);
            dp[i+1][j]=ans1;
        }else{
            ans1=dp[i+1][j];
        }

        if(dp[i][j+1] == Integer.MAX_VALUE){
            ans2=getMinCostM(cost, i,j+1,dp);
            dp[i][j+1]=ans2;
        }else{
            ans2=dp[i][j+1];
        }

        if(dp[i+1][j+1] == Integer.MAX_VALUE){
            ans3=getMinCostM(cost, i+1,j+1,dp);
            dp[i+1][j+1]=ans3;
        }else{
            ans3=dp[i+1][j+1];
        }
        int ans=Math.min(ans1,Math.min(ans2,ans3))+cost[i][j];
        return  ans;
    }

    public static void main(String[] args) {
//        int cost[][]= { {1, 2, 3},
//                        {4, 8, 2},
//                        {1, 5, 3} };

        int cost[][]= { {1, 5, 11},
                        {8, 13, 12},
                        {2, 3, 7},
                        {15,16,18}  };


        int dp[][] = new int [cost.length+1][cost[0].length+1];

        for(int i=0;i<=cost.length;i++){
            for(int j=0; j<=cost[0].length;j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        System.out.println(getMinCostM(cost,0,0,dp));
    }
}
