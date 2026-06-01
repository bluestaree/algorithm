package com.leetcode._2026_5;

import org.junit.Test;


/**
 * 1513. 仅含 1 的子串数
 *
 * @author DHW
 * @date 2026/5/6 11: 02
 * @Version 1.0
 */
public class ProblemsNo1513 {

    @Test
    public void solution() {
        String s = "heeellooo";
        System.out.println("res = " + numSub(s));
    }

    public int numSub(String s) {
        int ans = 0;
        int mod = (int) 1e9 + 7;
        int n = s.length();
        int last0 = -1;
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '0') {
                last0 = i;
            } else {
                ans += i - last0;
            }

        }
        return (int) (ans % mod);
    }
}

