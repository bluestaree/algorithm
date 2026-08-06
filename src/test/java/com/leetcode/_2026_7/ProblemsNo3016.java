package com.leetcode._2026_7;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3016. 输入单词需要的最少按键次数 II
 *
 * @author DHW
 * @date 2026/7/31 8:31
 * @Version 1.0
*/
public class ProblemsNo3016 {

    @Test
    public void solution() {
        String s = "bbb";
        System.out.println("res = " + minimumPushes(s));
    }

    public int minimumPushes(String word) {
        int[] cnt = new int[26];
        char[] charArray = word.toCharArray();
        for (char c : charArray) {
            cnt[c - 'a']++;
        }
        Arrays.sort(cnt);

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += cnt[25 - i] * (i / 8 + 1);
        }
        return ans;

    }

}
