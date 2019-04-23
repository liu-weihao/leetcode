package com.dx.ss.leetcode.BuyandSellStock;

public class MaxStockProfit {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int buy = prices[0], profit = 0;
        for (int price : prices) {
            int diff = price - buy;//差价
            if (diff > profit) {
                profit = diff;
            }
            if (price < buy) {
                buy = price;
            }
        }
        return profit;
    }

    public static void main(String[] args){
        MaxStockProfit maxStockProfit = new MaxStockProfit();
        int maxProfit = maxStockProfit.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(maxProfit);
    }
}
