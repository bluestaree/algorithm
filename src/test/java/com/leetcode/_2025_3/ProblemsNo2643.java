package com.leetcode._2025_3;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2643. 一最多的行
 *
 * @author DHW
 * @date 2025/3/22 10: 46
 * @Version 1.0
*/
public class ProblemsNo2643 {

    @Test
    public void solution() {
        int[][] mat = new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}};
        System.out.println("res = " + rowAndMaximumOnes(mat));
    }

    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] res = new int[2];
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }
            if (res[1] < count) {
                res[0] = i;
                res[1] = count;
            }
        }
        return res;
    }
}

