package com.leetcode._2026_1;

import org.junit.Test;


/**
 * 2730. 找到最长的半重复子字符串
 *
 * @author DHW
 * @date 2026/1/7 9: 48
 * @Version 1.0
*/
public class ProblemsNo2730 {

    @Test
    public void solution() {
        String s = "52233";
        System.out.println("res = " + longestSemiRepetitiveSubstring(s));
    }

    public int longestSemiRepetitiveSubstring(String s) {
        int ans = 1;
        char[] charArray = s.toCharArray();
        int l = 0;
        int count = 0;
        for (int r = 1; r < charArray.length; r++) {
            if(charArray[r] == charArray[r - 1]) {
                count++;
            }
            while (count > 1) {
                if(charArray[l] == charArray[l + 1]) {
                    count--;
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}

