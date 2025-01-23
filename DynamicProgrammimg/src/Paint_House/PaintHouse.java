package Paint_House;

//https://leetcode.com/problems/paint-house/
/*
There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.
 */
/*
*
* we should know the color we are ending with, if the nth house end with RED color then n-1 only can be BLUE or GREEN for n-1
*
* dp[i][R]  :  minimum cost to paint all houses from [0-i]  such that i-th house is RED;
* dp[i][B]  :  minimum cost to paint all houses from [0-i]  such that i-th house is BLUE;
* dp[i][G]  :  minimum cost to paint all houses from [0-i]  such that i-th house is GREEN;
*
* dp[i][0]  :  minimum cost to paint all houses from [0-i]  such that i-th house is RED;  :: 0->RED
* dp[i][1]  :  minimum cost to paint all houses from [0-i]  such that i-th house is BLUE; ::1->BLUE
* dp[i][2]  :  minimum cost to paint all houses from [0-i]  such that i-th house is GREEN;::2->GREEN
*
* we for a DP now of n*3  =>i : 0..n
*
*
* dp[i][0] =>R[i] + min(dp[i-1][1],dp[i-1][2])
* dp[i][1] =>B[i] + min(dp[i-1][0],dp[i-1][2])
* dp[i][2] =>G[i] + min(dp[i-1][0],dp[i-1][1])
*
* dp[0][0] : R[0] : cost of the paint to 0-th house with RED
* dp[0][1] : R[1] : cost of the paint to 1-st house with BLUE
* dp[0][2] : R[2] : cost of the paint to 2-nd house with GREEN
*
* dp[n-1][0] : R[0] : cost of the paint to n-1th house with RED
* dp[n-1][1] : R[1] : cost of the paint to n-1th house with BLUE
* dp[n-1][2] : R[2] : cost of the paint to n-1th house with GREEN
*
* */
public class PaintHouse {

    public int minCost(int[][] costs) {
        int n= costs.length;
        int[][] dp = new int[n][3];

        dp[0][0]=costs[0][0];
        dp[0][1]=costs[0][1];
        dp[0][2]=costs[0][2];

        for(int i=1;i<n;i++){
            dp[i][0]= costs[i][0]+Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1]= costs[i][1]+Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2]= costs[i][2]+Math.min(dp[i-1][0],dp[i-1][1]);
        }

        return Math.min(dp[n-1][0],Math.min(dp[n-1][1],dp[n-1][2]));

    }
}
