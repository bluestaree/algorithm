package com.leetcode._2026_2;

import org.junit.Test;

import java.util.Arrays;


/**
 * 557. 反转字符串中的单词 III
 *
 * @author DHW
 * @date 2026/2/27 9: 17
 * @Version 1.0
*/
public class ProblemsNo557 {

    @Test
    public void solution() {
        String s = "QWER";
        System.out.println("res = " + reverseWords(s));
    }

    public String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String sl : split) {
            char[] charArray = sl.toCharArray();
            int l = 0, r = charArray.length - 1;
            while (l < r) {
                char temp = charArray[l];
                charArray[l] = charArray[r];
                charArray[r] = temp;
                l++;
                r--;
            }
            sb.append(charArray).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}

