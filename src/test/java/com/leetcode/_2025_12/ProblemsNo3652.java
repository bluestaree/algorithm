package com.leetcode._2025_12;

import org.junit.Test;


/**
 * 3652. 按策略买卖股票的最佳时机
 *
 * @author DHW
 * @date 2025/12/11 9: 27
 * @Version 1.0
*/
public class ProblemsNo3652 {

    @Test
    public void solution() {
        int[] prices =  new int[]{1,2,3,4,5,6,1};
        int[] strategy =  new int[]{1,2,3,4,5,6,1};
        int k = 3;
        System.out.println("res = " + maxProfit(prices, strategy, k));
    }

    public long maxProfit(int[] prices, int[] strategy, int k) {
        long total = 0, sum = 0;
        // 计算第一个窗口的 sum
        for (int i = 0; i < k / 2; i++) {
            int p = prices[i], s = strategy[i];
            total += p * s;
            sum -= p * s;
        }
        for (int i = k / 2; i < k; i++) {
            int p = prices[i], s = strategy[i];
            total += p * s;
            sum += p * (1 - s);
        }

        long maxSum = Math.max(sum, 0);
        // 向右滑动，计算后续窗口的 sum
        for (int i = k; i < prices.length; i++) {
            int p = prices[i], s = strategy[i];
            total += p * s;
            sum += p * (1 - s) - prices[i - k / 2] + prices[i - k] * strategy[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        return total + maxSum;
    }

}

