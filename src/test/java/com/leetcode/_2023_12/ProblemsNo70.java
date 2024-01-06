package com.leetcode._2023_12;

import org.junit.Test;


/**
 * 70. 爬楼梯
 *
 * @author DHW
 * @date 2023/12/10 10:50
 * @Version 1.0
*/
public class ProblemsNo70 {

    @Test
    public void solution() {
        int n = 3;
        System.out.println("res = " + climbStairs(n));
    }

    public int climbStairs(int n) {
        int[] f = new int[45];
        f[0] = 1; f[1] = 3;
        for (int i = 2; i < n; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f[n-1];
    }
}

