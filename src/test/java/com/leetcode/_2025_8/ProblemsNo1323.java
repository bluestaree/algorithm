package com.leetcode._2025_8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 1323. 6 和 9 组成的最大数字
 *
 * @author DHW
 * @date 2025/8/16 10: 55
 * @Version 1.0
*/
public class ProblemsNo1323 {

    @Test
    public void solution() {
        int num = 6;
        System.out.println("res = " + maximum69Number(num));
    }

    public int maximum69Number (int num) {
        return Integer.valueOf(String.valueOf(num).replaceFirst("6", "9"));
    }
}

