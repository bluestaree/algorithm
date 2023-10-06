package com.leetcode._2023_10;

import org.junit.Test;


/**
 * 309. 买卖股票的最佳时机含冷冻期
 *
 * @author DHW
 * @date 2023/10/5 18:33
 * @Version 1.0
*/
public class ProblemsNo309 {

    @Test
    public void solution() {
        int[] prices = new int[]{1,2,3,1};
        System.out.println("res = " + maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] f = new int[len][2];
        f[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            f[i][0] = Math.max(f[i-1][0], f[i-1][1] + prices[i]);
            f[i][1] = Math.max(f[i-1][1], i > 1 ? f[i-2][0] - prices[i] : f[i-1][0] - prices[i]);
        }
        return f[len][0];
    }
}

