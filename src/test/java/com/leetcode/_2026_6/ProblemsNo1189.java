package com.leetcode._2026_6;

import org.junit.Test;


/**
 * 1189. “气球” 的最大数量
 *
 * @author DHW
 * @date 2026/6/22 8: 34
 * @Version 1.0
 */
public class ProblemsNo1189 {

    @Test
    public void solution() {
        String text = "dcacccaa";
        System.out.println("res = " + maxNumberOfBalloons(text));
    }

    public int maxNumberOfBalloons(String text) {
        int[] cnt = new int[26];
        for (char c : text.toCharArray()) {
            cnt[c - 'a']++;
        }
        int ans = text.length();
        ans = Math.min(ans, cnt['b' - 'a']);
        ans = Math.min(ans, cnt['a' - 'a']);
        ans = Math.min(ans, cnt['n' - 'a']);
        ans = Math.min(ans, cnt['l' - 'a'] / 2);
        ans = Math.min(ans, cnt['o' - 'a'] / 2);
        return ans;
    }
}

