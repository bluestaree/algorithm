package com.leetcode._2024_11;

import org.junit.Test;


/**
 * 3258. 统计满足 K 约束的子字符串数量 I
 *
 * @author DHW
 * @date 2024/11/12 8: 48
 * @Version 1.0
*/
public class ProblemsNo3258 {

    @Test
    public void solution() {
        String s = "10101";
        int k = 1;
        System.out.println("res = " + countKConstraintSubstrings(s, k));
    }

    public int countKConstraintSubstrings(String s, int k) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int[] cnt = new int[2];
            for (int j = i; j < n; j++) {
                cnt[s.charAt(j) - '0']++;
                if(cnt[0] > k && cnt[1] > k) {
                    break;
                }
                res++;
            }
        }
        return res;
    }
}

