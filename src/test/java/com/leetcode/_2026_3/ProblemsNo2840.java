package com.leetcode._2026_3;

import org.junit.Test;


/**
 * 2697. 字典序最小回文串
 *
 * @author DHW
 * @date 2026/3/2 9: 57
 * @Version 1.0
 */
public class ProblemsNo2840 {

    @Test
    public void solution() {
        String s1 = "cat and mice";
        String s2 = "cat and mice";
        System.out.println("res = " + checkStrings(s1, s2));
    }

    public boolean checkStrings(String s1, String s2) {
        int[][] cnt1 = new int[2][26];
        int[][] cnt2 = new int[2][26];
        int n = s1.length();
        char[] charArray = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();
        for (int i = 0; i < n; i++) {
            cnt1[i % 2][charArray[i] - 'a']++;
            cnt2[i % 2][charArray2[i] - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt1[0][i] != cnt2[0][i] || cnt1[1][i] != cnt2[1][i]) {
                return false;
            }
        }
        return true;
    }
}

