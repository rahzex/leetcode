package com.leetcode.easy;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
// https://www.youtube.com/watch?v=eMSfBgbiEjk

public class BuyAndSellStock {

    public static int maxProfit(int[] prices) {

        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - min);
            if (prices[i] < min)
                min = prices[i];
        }
        return profit;
    }

    public int maxProfit1(int[] prices) {
        int profit = 0;
        int maxProfit = 0;
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (minPrice < prices[i]) {
                profit = prices[i] - minPrice;
                if (profit > maxProfit)
                    maxProfit = profit;
            } else if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {3,2,6,5,0,3}));
    }
}

// [7,1,5,3,6,4]
// [3,2,6,5,0,3]
// [3,3,5,0,0,3,1,4]
