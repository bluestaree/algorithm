package com.leetcode._2023_1;

import org.junit.Test;

import java.util.Arrays;


/**
 * 1806. 还原排列的最少操作步数
 *
 * @author DHW
 * @date 2023/1/9 9:12
 * @Version 1.0
*/
public class ProblemsNo1806 {

    @Test
    public void solution() {
        int n = 6;
        System.out.println("res = " + reinitializePermutation(n));
    }

    public int reinitializePermutation(int n) {
        int res = 0;
        int[] perm = new int[n];
        int[] target = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
            target[i] = i;
        }
        while (true) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                if(i % 2 == 0) {
                    arr[i] = perm[i / 2];
                } else {
                    arr[i] = perm[n / 2 + (i - 1) / 2];
                }
            }
            perm = arr;
            res++;
            if(Arrays.equals(arr, target)) {
                break;
            }
        }
        return res;
    }
}
