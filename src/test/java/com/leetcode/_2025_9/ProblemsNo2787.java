package com.leetcode._2025_9;

import org.junit.Test;


/**
 * 1304. 和为零的 N 个不同整数
 *
 * @author DHW
 * @date 2025/9/7 10: 33
 * @Version 1.0
*/
public class ProblemsNo2787 {

    @Test
    public void solution() {
        int n = 4;
        System.out.println("res = " + sumZero(n));
    }

    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int t = n / 2;
        int j = 0;
        for (int i = 1; i <= t; i++) {
            ans[j++] = i;
            ans[j++] = 0 - i;
        }
        return ans;
    }
}

