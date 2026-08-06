package com.leetcode._2026_8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 3345. 最小可整除数位乘积 I
 *
 * @author DHW
 * @date 2026/8/06 8:50
 * @Version 1.0
*/
public class ProblemsNo3345 {

    @Test
    public void solution() {
        int n = 1;
        int t = 1;
        System.out.println("res = " + smallestNumber(n, t));
    }

    public int smallestNumber(int n, int t) {
        for (int i = n; ; i++) {
            int prod = 1;
            for (int x = i; x > 0; x /= 10) {
                prod *= x % 10;
            }

            if(prod % t == 0) {
                return i;
            }
        }
    }
}

