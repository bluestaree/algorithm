package com.leetcode._2023_10;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2578. 最小和分割
 *
 * @author DHW
 * @date 2023/10/9 9:35
 * @Version 1.0
*/
public class ProblemsNo2578 {

    @Test
    public void solution() {
        int num = 1;
        System.out.println("res = " + splitNum(num));
    }

    public int splitNum(int num) {
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < chars.length; i++) {
            if(i % 2 == 0) {
                num1 = num1 * 10 + (chars[i] - '0') ;
            } else {
                num2 = num2 * 10 + (chars[i] - '0') ;
            }
        }
        return num1 + num2;
    }
}

