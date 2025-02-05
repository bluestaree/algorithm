package com.leetcode._2025_1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;


/**
 * 2264. 字符串中最大的 3 位相同数字
 *
 * @author DHW
 * @date 2022/1/8 8: 31
 * @Version 1.0
*/
public class ProblemsNo2264 {

    @Test
    public void solution() {
        String s = "6777133339";
        System.out.println("res = " + largestGoodInteger(s));
    }

    public String largestGoodInteger(String num) {
        for (int i = 9; i >= 0; i--) {
            String s = i == 0 ? "000" : Integer.toString(i * 111);
            if (num.contains(s)) {
                return s;
            }
        }
        return "";
    }
}

