package com.leetcode._2026_2;

import org.junit.Test;


/**
 * 3775. 反转元音数相同的单词
 *
 * @author DHW
 * @date 2026/2/28 9: 19
 * @Version 1.0
*/
public class ProblemsNo3775 {

    @Test
    public void solution() {
        String s = "cat and mice";
        System.out.println("res = " + reverseWords(s));
    }

    public String reverseWords(String s) {
        String[] a = s.split(" ");
        int cnt0 = countVowel(a[0]);
        for (int i = 1; i < a.length; i++) {
            if (countVowel(a[i]) == cnt0) {
                a[i] = new StringBuilder(a[i]).reverse().toString();
            }
        }
        return String.join(" ", a);
    }

    private int countVowel(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) {
                cnt++;
            }
        }
        return cnt;
    }
}

