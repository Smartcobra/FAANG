package Paint_House_II;

import java.util.Scanner;

/*
There are a row of n houses, each house can be painted with one of the k colors. The cost of  painting each house with a certain color is different. You have to

 paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x k cost matrix.
For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.

 Input: [[1,5,3],[2,9,4]]
Output: 5
Explanation: Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5;
             Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5.

 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int c= sc.nextInt();

        int [][] arr= new int [n][c];

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]=sc.nextInt();
            }
        }

        int [][] dp= new int [arr.length][arr[0].length];

        for(int j=0;j<arr[0].length;j++){
            dp[0][j] = arr[0][j];
        }

        for(int i=1;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                int min= Integer.MAX_VALUE;

                for(int k=0;k<dp[0].length;k++){
                    if(k!=j){
                        min = Math.min(dp[i-1][k],min);
                    }
                }
                dp[i][j] = arr[i][j]+min;
            }
        }

        int min = Integer.MAX_VALUE;
        for(int k=0;k<dp[0].length;k++){
            min = Math.min(min,dp[dp.length-1][k]);
        }

        System.out.println(min);
    }

}
