package com.leetcode._2024_6;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


/**
 * 2710. 移除字符串中的尾随零
 *
 * @author DHW
 * @date 2024/6/29 10:53
 * @Version 1.0
*/
public class ProblemsNo2710 {

    @Test
    public void solution() {
        String num = "123";
        System.out.println("res = " + removeTrailingZeros(num));
    }

    public String removeTrailingZeros(String num) {
        int i = num.length() - 1;
        while (num.charAt(i) == '0') {
            i--;
        }
        return num.substring(0, i + 1);
    }
}

