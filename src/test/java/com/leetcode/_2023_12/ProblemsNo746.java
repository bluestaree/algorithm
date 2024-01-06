package com.leetcode._2023_12;

import org.junit.Test;


/**
 * 746. 使用最小花费爬楼梯
 *
 * @author DHW
 * @date 2023/12/17 11:00
 * @Version 1.0
*/
public class ProblemsNo746 {

    @Test
    public void solution() {
        int[] cost = new int[]{6,2,3,1,4,5};
        System.out.println("res = " + minCostClimbingStairs(cost));
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] f = new int[n + 1];
        for (int i = 2; i <= n; ++i) {
            f[i] = Math.min(f[i - 2] + cost[i - 2], f[i - 1] + cost[i - 1]);
        }
        return f[n];

    }
}

