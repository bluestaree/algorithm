package com.leetcode._2024_8;

import org.junit.Test;


/**
 * 3146. 两个字符串的排列差
 *
 * @author DHW
 * @date 2024/8/24 12:20
 * @Version 1.0
*/
public class ProblemsNo3146 {

    @Test
    public void solution() {
        String s = "abc";
        String t = "bac";
        System.out.println("res = " + findPermutationDifference(s, t));
    }

    public int findPermutationDifference(String s, String t) {
        int[] d = new int[26];
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            d[s.charAt(i) - 'a'] = i;
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += Math.abs(d[t.charAt(i) - 'a'] - i);
        }
        return ans;
    }
}

