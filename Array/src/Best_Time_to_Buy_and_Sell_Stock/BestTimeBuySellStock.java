package Best_Time_to_Buy_and_Sell_Stock;

public class BestTimeBuySellStock {

    public static int maxProfit(int[] prices) {

        ///https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
        int lowest_price_so_far = Integer.MAX_VALUE;
       // int if_sold_today = 0;
        int overal_profit = 0;

        for (int price : prices) {
            if (price < lowest_price_so_far) {
                lowest_price_so_far = price;
            }
            int if_sold_today_profit = price - lowest_price_so_far;

            if (if_sold_today_profit > overal_profit) {
                overal_profit = if_sold_today_profit;
            }
            /*
              from line 16 to 20 can be replaced by-->
            overal_profit=Math.max(overal_profit,price - lowest_so_far);
            * */

        }
        return overal_profit;
    }

    public static void main(String[] args) {
        int [] arr={7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }
}
