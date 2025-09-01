package com.leetcode._2025_8;

import org.junit.Test;

import java.util.ArrayList;


/**
 * 2787. 将一个数字表示成幂的和的方案数
 *
 * @author DHW
 * @date 2025/8/12 10: 12
 * @Version 1.0
*/
public class ProblemsNo2787 {

    @Test
    public void solution() {
        int n = 4;
        int x = 1;
        System.out.println("res = " + numberOfWays(n, x));
    }


    public int numberOfWays(int n, int x) {
        final int mod = (int) 1e9 + 7;
        int[][] f = new int[n + 1][n + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            long k = (long) Math.pow(i, x);
            for (int j = 0; j <= n; ++j) {
                f[i][j] = f[i - 1][j];
                if (k <= j) {
                    f[i][j] = (f[i][j] + f[i - 1][j - (int) k]) % mod;
                }
            }
        }
        return f[n][n];
    }
}

