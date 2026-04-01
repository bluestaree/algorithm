package com.leetcode._2026_3;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3814. 预算下的最大总容量
 *
 * @author DHW
 * @date 2026/3/23 10: 20
 * @Version 1.0
 */
public class ProblemsNo3814 {

    @Test
    public void solution() {
        int[] costs = new int[]{8,7,1};
        int[] capacity = new int[]{7,4,2};
        int budget = 11;
        System.out.println("res = " + maxCapacity(costs, capacity, budget));
    }

    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n = costs.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (i, j) -> costs[i] - costs[j]); // 按照价格从小到大排序

        int[] preMax = new int[n + 1];
        int l = 0;
        int ans = 0;
        // 枚举买机器 r
        for (int r = n - 1; r >= 0; r--) {
            if (costs[idx[r]] >= budget) {
                continue; // 太贵的机器直接忽略
            }
            while (l < r && costs[idx[l]] + costs[idx[r]] < budget) {
                preMax[l + 1] = Math.max(preMax[l], capacity[idx[l]]);
                l++;
            }
            // 循环结束后，下标在范围 [0, min(l-1, r-1)] 中的机器都可以买
            ans = Math.max(ans, preMax[Math.min(l, r)] + capacity[idx[r]]);
        }
        return ans;
    }

}

