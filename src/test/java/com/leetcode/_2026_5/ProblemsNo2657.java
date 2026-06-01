package com.leetcode._2026_5;

import org.junit.Test;


/**
 * 2657. 找到两个数组的前缀公共数组
 *
 * @author DHW
 * @date 2026/5/20 8: 45
 * @Version 1.0
 */
public class ProblemsNo2657 {

    @Test
    public void solution() {
        int[] A = new int[]{1,3,54,4,7};
        int[] B = new int[]{1,3,5,4,7};
        System.out.println("res = " + findThePrefixCommonArray(A, B));
    }

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        long a = 0L;
        long b = 0L;
        for (int i = 0; i < n; i++) {
            a |= 1L << A[i];
            b |= 1L << B[i];
            ans[i] = Long.bitCount(a & b);
        }
        return ans;
    }

}

