package com.leetcode._2026_2;

import org.junit.Test;

import java.util.Arrays;
import java.util.Locale;


/**
 * 3713. 最长的平衡子串 I
 *
 * @author DHW
 * @date 2026/2/12 8: 54
 * @Version 1.0
*/
public class ProblemsNo3713 {

    @Test
    public void solution() {
        String s = "QWER";
        System.out.println("res = " + longestBalanced(s));
    }

    public int longestBalanced(String s) {
        int ans = 0;
        int[] cnt = new int[26];
        char[] charArray = s.toCharArray();
        int v = 0;
        int mx = 0;
        for (int i = 0; i < charArray.length; i++) {
            Arrays.fill(cnt, 0);
            v = 0;
            mx = 0;
            for (int j = i; j < charArray.length; j++) {
                int index = charArray[j] - 'a';
                if(cnt[index]++ == 0) {
                    v++;
                }
                mx = Math.max(mx, cnt[index]);
                if (v * mx == j - i + 1) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
}

