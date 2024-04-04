package com.leetcode._2024_3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;


/**
 * 2549. 统计桌面上的不同数字
 *
 * @author DHW
 * @date 2024/3/23 11:27
 * @Version 1.0
*/
public class ProblemsNo2549 {

    @Test
    public void solution() {
        int n = 6;
        System.out.println("res = " + distinctIntegers(n));
    }

    public int distinctIntegers(int n) {
        return Math.max(n - 1, 1);
    }

}

