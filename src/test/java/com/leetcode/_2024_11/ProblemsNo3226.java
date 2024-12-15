package com.leetcode._2024_11;

import org.junit.Test;


/**
 * 3226. 使两个整数相等的位更改次数
 *
 * @author DHW
 * @date 2024/11/2 11: 08
 * @Version 1.0
*/
public class ProblemsNo3226 {

    @Test
    public void solution() {
        int n = 4;
        int k = 5;
        System.out.println("res = " + minChanges(n, k));
    }

    public int minChanges(int n, int k) {
        return (n & k) == k ? Integer.bitCount(n ^ k) : -1;
    }
}

