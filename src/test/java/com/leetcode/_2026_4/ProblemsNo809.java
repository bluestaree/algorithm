package com.leetcode._2026_4;

import org.junit.Test;

import java.util.concurrent.Callable;


/**
 * 809. 情感丰富的文字
 *
 * @author DHW
 * @date 2026/4/9 10: 11
 * @Version 1.0
 */
public class ProblemsNo809 {

    @Test
    public void solution() {
        String s = "heeellooo";
        String[] words = new String[]{"helloo"};
        System.out.println("res = " + expressiveWords(s, words));
    }

    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        for (String t : words) {
            if (check(s, t)) {
                ++ans;
            }
        }
        return ans;
    }

    private boolean check(String s, String t) {
        int m = s.length(), n = t.length();
        if (n > m) {
            return false;
        }
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (s.charAt(i) != t.charAt(j)) {
                return false;
            }
            int k = i;
            while (k < m && s.charAt(k) == s.charAt(i)) {
                ++k;
            }
            int c1 = k - i;
            i = k;
            k = j;
            while (k < n && t.charAt(k) == t.charAt(j)) {
                ++k;
            }
            int c2 = k - j;
            j = k;
            if (c1 < c2 || (c1 < 3 && c1 != c2)) {
                return false;
            }
        }
        return i == m && j == n;
    }
}

