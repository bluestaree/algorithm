package com.leetcode._2023_4;

import org.junit.Test;


/**
 * 2413. 最小偶倍数
 *
 * @author DHW
 * @date 2023/4/21 11:02
 * @Version 1.0
*/
public class ProblemsNo2413 {

    @Test
    public void solution() {
        int n = 32;
        System.out.println("res = " + smallestEvenMultiple(n));
    }

    public int smallestEvenMultiple(int n) {
        return n % 2 == 0 ? n : n << 1;
    }
}
