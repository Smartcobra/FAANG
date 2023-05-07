package Best_Time_to_Buy_and_Sell_Stock_II;


///https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
/*
* As per the question everytime we have a profit we can buy
*  Input: prices = [7,1,5,3,6,4]
*
*       |
*     7 |*
*     6 |                     *
*     5 |         *
*     4 |                         *
*     3 |              *
*     2 |
*     1 |    *
*       |_________________________________________
*       0    1    2    3    4    5    6    7
*
*       we need to add only profit , so to add where we are an increase in value  ,  index-1:index-2  5-1 ,  index-3:index-4  6-3
*
*
* */
public class BestTimeBuySellStockII {
    public int maxProfit(int[] prices) {

        int n= prices.length;
        int profit=0;
        for(int i=1;i<n;i++){
            if(prices[i]>prices[i-1]){
                profit +=prices[i]-prices[i-1];
            }
        }
    return profit;
    }

}
