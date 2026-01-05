package com.leetcode._2025_12;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


/**
 * 1208. 尽可能使字符串相等
 *
 * @author DHW
 * @date 2025/12/18 8: 47
 * @Version 1.0
*/
public class ProblemsNo1208 {

    @Test
    public void solution() {
        String s = "abcd";
        String t = "cdef";
        int maxCost = 3;
        System.out.println("res = " + equalSubstring(s, t, maxCost));
    }

    public int equalSubstring(String s, String t, int maxCost) {
        int ans = 0;
        int n = s.length();
        int l = 0;
        int cost = 0;
        for (int i = 0; i < n; i++) {
            cost += Math.abs(s.charAt(i) - t.charAt(i));
            while (cost > maxCost) {
                cost -= Math.abs(s.charAt(l) - t.charAt(l));
                l++;
            }
            ans = Math.max(ans, i - l + 1);
        }
        return ans;
    }
}

