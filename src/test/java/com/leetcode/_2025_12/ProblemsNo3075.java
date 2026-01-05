package com.leetcode._2025_12;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3075. 幸福值最大化的选择方案
 *
 * @author DHW
 * @date 2025/12/25 8: 52
 * @Version 1.0
*/
public class ProblemsNo3075 {

    @Test
    public void solution() {
        int[] happiness =  new int[]{1,34,23};
        int k = 2;
        System.out.println("res = " + maximumHappinessSum(happiness, k));
    }

    public long maximumHappinessSum(int[] happiness, int k) {
        long ans = 0;
        int t = 0;
        Arrays.sort(happiness);
        for (int i = happiness.length - 1; i >= 0 && k > 0; i--, k--) {
            ans += Math.max(0, happiness[i] - t);
            t++;
        }
        return ans;
    }
}

