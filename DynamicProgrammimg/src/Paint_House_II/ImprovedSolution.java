package Paint_House_II;

import java.util.Scanner;

public class ImprovedSolution {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int c= sc.nextInt();

        int [][] arr = new int[n][c];

        for(int i=0;i<n;i++){
            for(int j=0;j<c;j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int[] dp = new int[c];

        for(int j=0;j<c;j++){
            dp[j]= arr[0][j];
        }


        for(int i=1;i<n;i++){
            int min1= Integer.MAX_VALUE;
            int min2= Integer.MAX_VALUE;
            int min1Idx=-1;

            for(int j=0;j<c;j++){
                if(dp[j]<min1){
                    min2=min1;
                    min1=dp[j];
                    min1Idx=j;
                } else if (dp[j]<min2) {
                    min2 = dp[j];

                }
            }

            int[] newDp = new int[c];

            for(int j=0;j<c;j++){
                if(j==min1Idx){
                    newDp[j] = arr[i][j]+min2;
                }else{
                    newDp[j] = arr[i][j]+min1;
                }
            }
            dp= newDp;
        }

        int min= Integer.MAX_VALUE;
        for(int j=0;j<c;j++){
            min=Math.min(dp[j],min);
        }

        System.out.println(min);
    }
}
