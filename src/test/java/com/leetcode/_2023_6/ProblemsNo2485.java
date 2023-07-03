package com.leetcode._2023_6;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;


/**
 * 2485. 找出中枢整数
 *
 * @author DHW
 * @date 2023/6/26 8:49
 * @Version 1.0
*/
public class ProblemsNo2485 {

    @Test
    public void solution() {
        int n = 8;
        System.out.println("res = " + pivotInteger(n));
    }

    public int pivotInteger(int n) {
        if(n == 1) {
            return n;
        }
        int sum1 = (1 + n) * n / 2;
        int sum2 = 0;
        for (int i = n; i > 0; i--) {
            sum2 += i;
            if(sum2 == sum1) {
                return i;
            }
            sum1 -= i;
            if(sum2 > sum1) {
                break;
            }
        }
        return -1;
    }
}
