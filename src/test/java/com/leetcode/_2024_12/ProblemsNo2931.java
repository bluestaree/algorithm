package com.leetcode._2024_12;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2931. 购买物品的最大开销
 *
 * @author DHW
 * @date 2024/12/12 9: 08
 * @Version 1.0
*/
public class ProblemsNo2931 {

    @Test
    public void solution() {
        int[][] values = new int[][]{new int[]{8,5,2},new int[]{6,4,1},new int[]{9,7,3}};
        System.out.println("res = " + maxSpending(values));
    }

    public long maxSpending(int[][] values) {
        int m = values.length;
        int n = values[0].length;
        int[] arr = new int[m*n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(values[i], 0, arr, i * n, n);
        }
        Arrays.sort(arr);
        long res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += (long) arr[i] * (i + 1);
        }
        return res;
    }
}

