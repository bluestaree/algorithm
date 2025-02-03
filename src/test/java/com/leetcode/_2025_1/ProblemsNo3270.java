package com.leetcode._2025_1;

import org.junit.Test;


/**
 * 3270. 求出数字答案
 *
 * @author DHW
 * @date 2025/1/11 10: 43
 * @Version 1.0
*/
public class ProblemsNo3270 {

    @Test
    public void solution() {
        int num1 = 12;
        int num2 = 12;
        int num3 = 12;
        System.out.println("res = " + generateKey(num1, num2, num3));
    }

    public int generateKey(int num1, int num2, int num3) {
        int ans = 0, k = 1;
        for (int i = 0; i < 4; ++i) {
            int x = Math.min(Math.min(num1 / k % 10, num2 / k % 10), num3 / k % 10);
            ans += x * k;
            k *= 10;
        }
        return ans;
    }
}

