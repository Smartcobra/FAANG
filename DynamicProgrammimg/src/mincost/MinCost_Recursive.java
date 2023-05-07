package mincost;

public class MinCost_Recursive {

    public static int getMinCost( int cost[][] , int i ,int j){
        int m=cost.length;
        int n= cost[0].length;

        if( i==m-1 && j==n-1){
            return cost[i][j];
        }
        if(i>=m || j>=n){
            return Integer.MAX_VALUE;
        }
        int vertical= getMinCost(cost, i+1,j);
        int horizontal= getMinCost(cost,i,j+1);
        int digonal=getMinCost(cost,i+1,j+1);
        int ans=Math.min(vertical,Math.min(horizontal,digonal))+cost[i][j];
        return  ans;
    }

    public static void main(String[] args) {
        int cost[][]= { {1, 2, 3},
                        {4, 8, 2},
                        {1, 5, 3} };
        System.out.println(getMinCost(cost,0,0));
    }
}
