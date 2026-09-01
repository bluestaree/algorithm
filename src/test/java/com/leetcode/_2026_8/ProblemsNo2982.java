package com.leetcode._2026_8;

import org.junit.Test;


/**
 * 2982. 找出出现至少三次的最长特殊子字符串 II
 *
 * @author DHW
 * @date 2026/8/26 9: 34
 * @Version 1.0
 */
public class ProblemsNo2982 {

    @Test
    public void solution() {
        String s = "aaaa";
        System.out.println("= res = " + maximumLength(s));
    }

    public int maximumLength(String s) {
        int left = 1;
        int right = s.length() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(check(mid, s)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right == 0 ? -1 : right;
    }

    private boolean check(int mid, String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length();) {
            int j = i + 1;
            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            int k = s.charAt(i) - 'a';
            cnt[k] += Math.max(0, j - i - mid + 1);
            if (cnt[k] >= 3) {
                return true;
            }
            i = j;
        }
        return false;
    }
}

