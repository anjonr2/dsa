package com.problemsolving.array.medium;

public class StockBuyAndSell {
    public int maxProfit(int[] prices) {
        int buy_price = prices[0];
        int max_profit = 0;
        for (int i = 1; i < prices.length; i += 1) {
            if (prices[i] < buy_price) {
                buy_price = prices[i];
            } else {
                int current_profit = prices[i] - buy_price;
                max_profit = Math.max(max_profit, current_profit);
            }
        }
        return max_profit;
    }
}
