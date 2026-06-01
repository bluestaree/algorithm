package com.leetcode._2026_5;

import org.junit.Test;


/**
 * 1759. 统计同质子字符串的数目
 *
 * @author DHW
 * @date 2026/5/28 10: 46
 * @Version 1.0
 */
public class ProblemsNo1759 {

    @Test
    public void solution() {
        String s = "abbcccaa";
        System.out.println("res = " + countHomogenous(s));
    }


    public int countHomogenous(String s) {
        int ans = 0;
        int mod = 1000000007;
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            while (j < s.length() && s.charAt(i) == s.charAt(j)) {
                j++;
            }
            int n = j - i;
            ans = (int) ((ans + (long) n * (n + 1) / 2) % mod);
            i = j - 1;
        }

        return ans;
    }
}

