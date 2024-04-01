package com.leetcode._2024_4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;


/**
 * 2810. 故障键盘
 *
 * @author DHW
 * @date 2024/4/1 9:50
 * @Version 1.0
*/
public class ProblemsNo2810 {

    @Test
    public void solution() {
        String s = "";
        System.out.println("res = " + finalString(s));
    }

    public String finalString(String s) {
        StringBuffer sb = new StringBuffer();
        for (char c : s.toCharArray()) {
            if(c == 'i') {
                sb.reverse();
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}

