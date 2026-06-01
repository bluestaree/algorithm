package com.leetcode._2026_5;

import org.junit.Test;


/**
 * 696. 计数二进制子串
 *
 * @author DHW
 * @date 2026/5/18 10: 23
 * @Version 1.0
 */
public class ProblemsNo696 {

    @Test
    public void solution() {
        String s = "00110011";
        System.out.println("res = " + countBinarySubstrings(s));
    }

    public int countBinarySubstrings(String s) {
        int pre = 0, cnt = 1, ans = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                cnt++;
            } else {
                ans += Math.min(pre, cnt);
                pre = cnt;
                cnt = 1;
            }
        }
        ans += Math.min(pre, cnt);
        return ans;
    }
}

