package com.leetcode._2026_2;

import org.junit.Test;


/**
 * 151. 反转字符串中的单词
 *
 * @author DHW
 * @date 2026/2/27 9: 31
 * @Version 1.0
*/
public class ProblemsNo151 {

    @Test
    public void solution() {
        String s = "a good   example";
        System.out.println("res = " + reverseWords(s));
    }

    public String reverseWords(String s) {
        String[] split = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            if(split[i].length() == 0) {
                continue;
            }
            sb.append(split[i]).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}

