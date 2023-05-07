package Best_Time_to_Buy_and_Sell_Stock;

public class BestTimeBuySellStock_Brutforce {

    public static  int maxProfit(int[] prices) {
        int max = 0;
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n-1; j++) {
                int profit = prices[j] - prices[i];

                if (profit > max) {
                    max = profit;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int [] arr={7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }
}
