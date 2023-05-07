package tiling;

public class Tiling2 {
    public static int getTypes(int n, int m){
        int dp[]    = new int [n+1];

        for(int i=1;i<=n;i++){
            if(i<m){
                dp[i]=1;
            }else if(i==m){
                dp[i]=2;
            }else{
                dp[i]=dp[i-1]+dp[i-m];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 7, m = 4;
        System.out.println(getTypes(7,4));
    }
}
