package com.leetcode._2022_10;

import org.junit.Test;

import java.util.Stack;


/**
 * 1768. 交替合并字符串
 *
 * @author DHW
 * @date 2022/10/23 11:04
 * @Version 1.0
*/
public class ProblemsNo1768 {

    @Test
    public void solution() {
        String s1 = "())()((";
        String s2 = "())()((";
        System.out.println("s = " + mergeAlternately(s1, s2));
    }

    public String mergeAlternately(String word1, String word2) {
        StringBuffer sb = new StringBuffer();
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int length1 = chars1.length;
        int length2 = chars2.length;
        for (int i = 0; i < length1; i++) {
            sb.append(chars1[i]);
            if(i < chars2.length) {
                sb.append(chars2[i]);
            }
        }

        if(length1 < length2) {
            for (int i = length1 ; i < length2; i++) {
                sb.append(chars2[i]);
            }
        }

        return sb.toString();
    }
}
