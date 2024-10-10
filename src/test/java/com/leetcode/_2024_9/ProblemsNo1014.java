package com.leetcode._2024_9;

import org.junit.Test;


/**
 * 1014. 最佳观光组合
 *
 * @author DHW
 * @date 2024/9/23 9:11
 * @Version 1.0
*/
public class ProblemsNo1014 {

    @Test
    public void solution() {
        int[] values = new int[]{4,8,2,8};
        System.out.println("res = " + maxScoreSightseeingPair(values));
    }

    public int maxScoreSightseeingPair(int[] values) {
        int res = 0;
        int a = values[0];
        for (int j = 1; j < values.length - 1; j++) {
            res = Math.max(res, a + values[j] - j);
            a = Math.max(a, values[j] + j);
        }
        return res;
    }
}

