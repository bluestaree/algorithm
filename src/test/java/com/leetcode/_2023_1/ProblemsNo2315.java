package com.leetcode._2023_1;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2315. 统计星号
 *
 * @author DHW
 * @date 2023/1/29 10:01
 * @Version 1.0
*/
public class ProblemsNo2315 {

    @Test
    public void solution() {
        String s = "yo|uar|e**|b|e***au|tifu|l";
        System.out.println("res = " + countAsterisks(s));
    }

    public int countAsterisks(String s) {
        int res = 0;
        String[] split = s.split("\\|");
        for (int i = 0; i < split.length; i += 2) {
            String s1 = split[i];
            char[] chars = s1.toCharArray();
            Arrays.sort(chars);
            for (int j = 0; j < chars.length; j++) {
                if(chars[j] == '*') {
                    res++;
                } else {
                    break;
                }
            }
        }
        return res;
    }
}
