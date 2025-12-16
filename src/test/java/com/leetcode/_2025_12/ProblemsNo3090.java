package com.leetcode._2025_12;

import org.junit.Test;


/**
 * 3090. 每个字符最多出现两次的最长子字符串
 *
 * @author DHW
 * @date 2025/12/15 9: 13
 * @Version 1.0
*/
public class ProblemsNo3090 {

    @Test
    public void solution() {
        String s = "bcbbbcba";
        System.out.println("res = " + maximumLengthSubstring(s));
    }

    public int maximumLengthSubstring(String s) {
        int ans = 0;
        char[] array = s.toCharArray();
        int[] cnt = new int[26];
        int l = 0;
        for (int i = 0; i < array.length; i++) {
            int j = array[i] - 'a';
            cnt[j]++;
            while(cnt[j] > 2) {
                cnt[array[l] - 'a']--;
                l++;
            }
            ans = Math.max(ans, i - l + 1);
        }
        return ans;
    }
}

