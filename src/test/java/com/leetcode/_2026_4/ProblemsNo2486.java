package com.leetcode._2026_4;

import org.junit.Test;


/**
 * 2486. 追加字符以获得子序列
 *
 * @author DHW
 * @date 2026/4/16 11: 32
 * @Version 1.0
 */
public class ProblemsNo2486 {

    @Test
    public void solution() {
        String s = "heeellooo";
        String t = "heeellooo";
        System.out.println("res = " + appendCharacters(s, t));
    }

    public int appendCharacters(String s, String t) {
        int ans = 0;
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == t.length() ? ans : t.length() - j;
    }
}

