package com.leetcode._2025_9;

import org.junit.Test;


/**
 * 1317. 将整数转换为两个无零整数的和
 *
 * @author DHW
 * @date 2025/9/8 9: 45
 * @Version 1.0
*/
public class ProblemsNo1317 {

    @Test
    public void solution() {
        int n = 4;
        System.out.println("res = " + getNoZeroIntegers(n));
    }

    public int[] getNoZeroIntegers(int n) {
        for (int a = 1;; ++a) {
            int b = n - a;
            if (!(a + "" + b).contains("0")) {
                return new int[] {a, b};
            }
        }
    }
}

