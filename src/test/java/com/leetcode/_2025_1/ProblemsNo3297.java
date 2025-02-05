package com.leetcode._2025_1;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3297. 统计重新排列后包含另一个字符串的子字符串数目 I
 *
 * @author DHW
 * @date 2022/1/9 8: 50
 * @Version 1.0
*/
public class ProblemsNo3297 {

    @Test
    public void solution() {
        String word1 = "dcbdcdccb";
        String word2 = "cdd";
        System.out.println("res = " + validSubstringCount(word1, word2));
    }

    public long validSubstringCount(String word1, String word2) {
        if (word1.length() < word2.length()) {
            return 0;
        }
        int[] cnt = new int[26];
        int need = 0;
        for (int i = 0; i < word2.length(); ++i) {
            if (++cnt[word2.charAt(i) - 'a'] == 1) {
                ++need;
            }
        }
        long ans = 0;
        int[] win = new int[26];
        for (int l = 0, r = 0; r < word1.length(); ++r) {
            int c = word1.charAt(r) - 'a';
            if (++win[c] == cnt[c]) {
                --need;
            }
            while (need == 0) {
                c = word1.charAt(l) - 'a';
                if (win[c] == cnt[c]) {
                    ++need;
                }
                --win[c];
                ++l;
            }
            ans += l;
        }
        return ans;
    }
}

