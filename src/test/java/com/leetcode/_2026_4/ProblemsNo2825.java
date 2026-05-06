package com.leetcode._2026_4;

import org.junit.Test;


/**
 * 2825. 循环增长使字符串子序列等于另一个字符串
 *
 * @author DHW
 * @date 2026/4/20 10: 50
 * @Version 1.0
 */
public class ProblemsNo2825 {

    @Test
    public void solution() {
        String str1 = "heeellooo";
        String str2 = "heeellooo";
        System.out.println("res = " + canMakeSubsequence(str1, str2));
    }

    public boolean canMakeSubsequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        if(n < m) {
            return false;
        }
        int i = 0, j = 0;
        while(i < n && j < m) {
            char ch1 = (char) (str1.charAt(i) + 1);
            if(ch1 > 'z') {
                ch1 = 'a';
            }
            if(str1.charAt(i) == str2.charAt(j) || ch1 == str2.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == m;
    }
}

