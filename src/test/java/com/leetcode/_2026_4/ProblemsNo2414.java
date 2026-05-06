package com.leetcode._2026_4;

import org.junit.Test;


/**
 * 2414. 最长的字母序连续子字符串的长度
 *
 * @author DHW
 * @date 2026/4/29 11: 03
 * @Version 1.0
 */
public class ProblemsNo2414 {

    @Test
    public void solution() {
        String s = "hello";
        System.out.println("sortArrayByParity(nums) = " + longestContinuousSubstring(s));
    }

    public int longestContinuousSubstring(String s) {
        int ans = 0;
        int cnt = 1;
        int n = s.length();
        for (int i = 1; i < n; i++) {
            if(s.charAt(i) - s.charAt(i-1) == 1) {
                cnt++;
                ans = Math.max(ans, cnt);
            } else {
                cnt = 1;
            }
        }
        return ans;
    }

}

