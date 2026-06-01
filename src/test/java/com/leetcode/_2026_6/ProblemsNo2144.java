package com.leetcode._2026_6;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2144. 打折购买糖果的最小开销
 *
 * @author DHW
 * @date 2026/6/1 8: 41
 * @Version 1.0
 */
public class ProblemsNo2144 {

    @Test
    public void solution() {
        int[] cost = new int[]{5,1,3};
        System.out.println("res = " + minimumCost(cost));
    }

    public int minimumCost(int[] cost) {
        int ans = 0;
        Arrays.sort(cost);
        for (int i = cost.length - 1; i >= 0; i-=3) {
            ans += cost[i];
            if(i > 0) {
                ans += cost[i] + cost[i-1];
            }
        }
        return ans;
    }

}

