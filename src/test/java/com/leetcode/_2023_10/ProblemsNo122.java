package com.leetcode._2023_10;

import org.junit.Test;

import java.util.Arrays;


/**
 * 122. 买卖股票的最佳时机II
 *
 * @author DHW
 * @date 2023/10/2 11:06
 * @Version 1.0
*/
public class ProblemsNo122 {

    @Test
    public void solution() {
        int[] prices = new int[]{1,2,3,1};
        System.out.println("res = " + maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }

    public int maxProfit1(int[] prices) {
        int n = prices.length;
        int[][] f = new int[n][2];
        f[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            f[i][0] = Math.max(f[i-1][0], f[i-1][1] + prices[i]);
            f[i][1] = Math.max(f[i-1][1], f[i-1][0] - prices[i]);
        }
        return f[n-1][0];
    }
}

