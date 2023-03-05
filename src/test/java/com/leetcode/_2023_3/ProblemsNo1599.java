package com.leetcode._2023_3;

import org.junit.Test;

import java.util.Arrays;


/**
 * 1599. 经营摩天轮的最大利润
 *
 * @author DHW
 * @date 2023/3/5 12:07
 * @Version 1.0
*/
public class ProblemsNo1599 {

    @Test
    public void solution() {
        int[] customers = new int[]{8,3};
        int boardingCost = 5;
        int runningCost = 6;
        System.out.println("res = " + minOperationsMaxProfit(customers, boardingCost, runningCost));
    }

    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int ans = -1;
        int mx = 0, t = 0;
        int wait = 0, i = 0;
        while (wait > 0 || i < customers.length) {
            wait += i < customers.length ? customers[i] : 0;
            int up = Math.min(4, wait);
            wait -= up;
            ++i;
            t += up * boardingCost - runningCost;
            if (t > mx) {
                mx = t;
                ans = i;
            }
        }
        return ans;
    }
}
