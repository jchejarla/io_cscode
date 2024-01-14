package io.cscode.algorithms.slidingwindow;

public class BestTimeToBuyAndSellStock {

    static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int left = 0;
        int right = 1;

        while(right <prices.length) {
            if(prices[left] < prices[right]) {
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(profit, maxProfit);
            } else {
                left = right;
            }
            right++;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
