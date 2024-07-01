package com.leetcode._2024_6;

import org.junit.Test;


/**
 * 2734. 执行子串操作后的字典序最小字符串
 *
 * @author DHW
 * @date 2024/6/27 9:22
 * @Version 1.0
*/
public class ProblemsNo2734 {

    @Test
    public void solution() {
        String s = "abc";
        System.out.println("res = " + smallestString(s));
    }

    public String smallestString(String s) {
        char[] array = s.toCharArray();
        boolean flag = false;
        for (int i = 0; i < array.length; i++) {
            if(array[i] != 'a') {
                array[i] -= 1;
                flag = true;
            } else if(flag) {
                break;
            }
        }
        if(!flag) {
            array[s.length() - 1] = 'z';
        }
        return new String(array);
    }
}

