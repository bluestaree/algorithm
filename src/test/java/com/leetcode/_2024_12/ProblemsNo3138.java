package com.leetcode._2024_12;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3138. 同位字符串连接的最小长度
 *
 * @author DHW
 * @date 2024/12/20 9: 19
 * @Version 1.0
*/
public class ProblemsNo3138 {

    @Test
    public void solution() {
        String s = "abbbaa";
        System.out.println("res = " + minAnagramLength(s));
    }

    int[] cnt;
    char[] sc;

    int n;

    public int minAnagramLength(String s) {
        this.sc = s.toCharArray();
        this.n = sc.length;
        this.cnt = new int[26];
        for (char c : sc) {
            cnt[c - 'a']++;
        }
        for (int i = 1;; ++i) {
            if (n % i == 0 && check(i)) {
                return i;
            }
        }

    }

    private boolean check(int k) {
        for (int i = 0; i < n; i+=k) {
            int[] cnt1 = new int[26];
            for (int j = i; j < i + k; j++) {
                cnt1[sc[j] - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                if(cnt1[j] * (n / k) != cnt[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

