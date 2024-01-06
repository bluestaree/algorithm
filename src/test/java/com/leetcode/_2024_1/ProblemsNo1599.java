package com.leetcode._2024_1;

import org.junit.Test;


/**
 * 1599. 经营摩天轮的最大利润
 *
 * @author DHW
 * @date 2024/1/1 11:20
 * @Version 1.0
*/
public class ProblemsNo1599 {

    @Test
    public void solution() {
        int[] customers = new int[]{8,3,0,0};
        int boardingCost = 5;
        int runningCost = 6;
        System.out.println("res = " + minOperationsMaxProfit(customers, boardingCost, runningCost));
    }

    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int runTime = -1;
        int wait = 0;
        int total = 0;
        int mx = 0;
        int i = 0;
        while (wait > 0 || i < customers.length){
            wait += i < customers.length ? customers[i] : 0;
            int n = Math.min(4, wait);
            wait -= n;
            ++i;
            total += n * boardingCost - runningCost;
            if (total > mx) {
                mx = total;
                runTime = i;
            }
        }
        return runTime;
    }
}

