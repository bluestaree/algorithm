package com.leetcode._2025_3;

import org.junit.Test;


/**
 * 2278. 字母在字符串中的百分比
 *
 * @author DHW
 * @date 2025/3/31 8: 29
 * @Version 1.0
*/
public class ProblemsNo2278 {

    @Test
    public void solution() {
        String s = "foobar";
        char letter = 'o';
        System.out.println("res = " + percentageLetter(s, letter));
    }

    public int percentageLetter(String s, char letter) {
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == letter) {
                num++;
            }
        }
        return  num * 100 / n;
    }
}

