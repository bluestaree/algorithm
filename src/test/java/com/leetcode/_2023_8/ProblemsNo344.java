package com.leetcode._2023_8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 344. 反转字符串
 *
 * @author DHW
 * @date 2023/8/7 10:24
 * @Version 1.0
*/
public class ProblemsNo344 {

    @Test
    public void solution() {
        char[] s = new char[]{'a', 'l', 'm'};
        reverseString(s);
        System.out.println("res = " + s);
    }

    public void reverseString(char[] s) {
        int length = s.length;
        for (int i = 0, j = length - 1; i < j; i++,j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}
