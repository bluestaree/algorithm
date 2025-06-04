package com.leetcode._2025_5;

import org.junit.Test;

import java.util.HashSet;


/**
 * 3335. 字符串转换后的长度 I
 *
 * @author DHW
 * @date 2025/5/13 8: 55
 * @Version 1.0
*/
public class ProblemsNo3335 {

    @Test
    public void solution() {
        String s = "abcyy";
        int t = 2;
        System.out.println("res = " + lengthAfterTransformations(s, t));
    }

    public int lengthAfterTransformations(String s, int t) {
        final int MOD =1000000007;
        int cnt = s.length();
        int[] cnts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnts[s.charAt(i) - 'a']++;
        }
        for (int i = t; i > 0; i--) {
            int z = cnts[25];
            cnt  = (cnt + z) % MOD;
            for (int j = 25; j > 0; j--) {
                cnts[j] = cnts[j-1];
            }
            cnts[1] = (cnts[1] + z) % MOD;
            cnts[0] = z;
        }
        return cnt;
    }
}

