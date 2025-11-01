package com.leetcode._2025_10;

import org.junit.Test;


/**
 * 1716.计算力扣银行的钱
 *
 * @author DHW
 * @date 2025/10/25 10: 36
 * @Version 1.0
*/
public class ProblemsNo1716 {

    @Test
    public void solution() {
        int n = 20;
        System.out.println("res = " + totalMoney(n));
    }

    public int totalMoney(int n) {
        int ans = 0;
        int a = 1;
        int b = 1;
        for (int i = 1; i <= n; i++,a++) {
            ans += a;
            if(i % 7 == 0) {
                a = b;
                b++;
            }
        }
        return ans;

    }
}

