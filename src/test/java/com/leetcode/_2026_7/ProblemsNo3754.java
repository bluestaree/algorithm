package com.leetcode._2026_7;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3754. 连接非零数字并乘以其数字和 I
 *
 * @author DHW
 * @date 2026/7/7 8: 38
 * @Version 1.0
 */
public class ProblemsNo3754 {

    @Test
    public void solution() {
        int k = 10203004;
        System.out.println("= res = " + sumAndMultiply(k));
    }

    public long sumAndMultiply(int n) {
        long sum = 0;
        long product = 0;
        String string = Integer.toString(n);
        for (int i = 0; i < string.length(); i++) {
            int digit = string.charAt(i) - '0';
            if (digit != 0) {
                sum += digit;
                product = product * 10 + digit;
            }
        }
        return sum * product;
    }
}

