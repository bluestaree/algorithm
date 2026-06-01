package com.leetcode._2026_5;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


/**
 * 3121. 统计特殊字母的数量 II
 *
 * @author DHW
 * @date 2026/5/26 8: 31
 * @Version 1.0
 */
public class ProblemsNo3121 {

    @Test
    public void solution() {
        String colors = "cCceDC";
        System.out.println("res = " + numberOfSpecialChars(colors));
    }

    public int numberOfSpecialChars(String word) {
        int[] a = new int[26];
        int[] b = new int[26];
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if(c >= 'a') {
                a[c - 'a'] = i + 1;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            char c = word.charAt(i);
            if(c < 'a') {
                b[c - 'A'] = i + 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (a[i] < b[i] && a[i] != 0 && b[i] != 0) {
                ans++;
            }
        }
        return ans;
    }
}

