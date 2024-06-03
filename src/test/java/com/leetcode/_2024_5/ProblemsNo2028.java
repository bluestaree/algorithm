package com.leetcode._2024_5;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;


/**
 * 2028. 找出缺失的观测数据
 *
 * @author DHW
 * @date 2024/5/27 10:40
 * @Version 1.0
*/
public class ProblemsNo2028 {

    @Test
    public void solution() {
        int[] rolls = new int[]{1,5,6};
        int mean = 3;
        int n = 4;
        System.out.println("res = " + missingRolls(rolls, mean, n));
    }

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int len = n+rolls.length;
        int num = Arrays.stream(rolls).sum();
        int x = mean * len - num;
        if (x < n || x > n * 6) {
            return new int[]{};
        }
        int a = x / n;
        int b = x % n;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = a + (i < b ? 1 : 0);
        }
        return res;
    }
}

