package com.leetcode._2022_11;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;


/**
 * 1678. 设计 Goal 解析器
 *
 * @author DHW
 * @date 2022/11/6 10:44
 * @Version 1.0
*/
public class ProblemsNo1678 {

    @Test
    public void solution() {
        String s = "(al)G(al)()()G";
        System.out.println("arr = " + interpret(s));
    }

    public String interpret(String command) {
        char[] chars = command.toCharArray();
        char[] res = new char[chars.length];
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                if(chars[i+1] == ')') {
                    res[j++] = 'o';
                    i++;
                } else {
                    res[j++] = 'a';
                    res[j++] = 'l';
                    i += 3;
                }
                continue;
            }
            res[j] = chars[i];
            j++;
        }
        return new String(Arrays.copyOf(res, j--));
    }

}
