package com.leetcode._2026_1;

import org.junit.Test;


/**
 * 3258. 统计满足 K 约束的子字符串数量 I
 *
 * @author DHW
 * @date 2026/1/16 9: 54
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
        int ans = 0;
        int l = 0;
        int[] count = new int[2];
        for (int r = 0; r < n; r++) {
            int x = s.charAt(r) - '0';
            count[x]++;
            while (count[0] > k && count[1] > k) {
                count[s.charAt(l) - '0']--;
                l++;
            }
            ans += r - l + 1;
        }
        return ans;
    }
}

