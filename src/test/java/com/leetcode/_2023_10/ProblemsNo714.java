package com.leetcode._2023_10;

import org.junit.Test;


/**
 * 714. 买卖股票的最佳时机含手续费
 *
 * @author DHW
 * @date 2023/10/6 16:56
 * @Version 1.0
*/
public class ProblemsNo714 {

    @Test
    public void solution() {
        int[] prices = new int[]{1,2,3,1};
        int fee = 2;
        System.out.println("res = " + maxProfit(prices, fee));
    }

    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int[][] f = new int[len][2];
        f[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            f[i][0] = Math.max(f[i-1][0], f[i-1][1] + prices[i] - fee);
            f[i][1] = Math.max(f[i-1][1], f[i-1][0] - prices[i]);
        }
        return f[len-1][0];
    }
}

