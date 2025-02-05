package com.leetcode._2025_1;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3065. 超过阈值的最少操作数 I
 *
 * @author DHW
 * @date 2022/1/14 8: 34
 * @Version 1.0
*/
public class ProblemsNo3065 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,6};
        int k = 2;
        System.out.println("res = " + minOperations(nums,k));
    }

    public int minOperations(int[] nums, int k) {
        return (int) Arrays.stream(nums).filter(a -> a < k).count();
    }
}

