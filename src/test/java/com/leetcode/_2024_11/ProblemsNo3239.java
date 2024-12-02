package com.leetcode._2024_11;

import org.junit.Test;


/**
 * 3239. 最少翻转次数使二进制矩阵回文 I
 *
 * @author DHW
 * @date 2024/11/15 8: 36
 * @Version 1.0
*/
public class ProblemsNo3239 {

    @Test
    public void solution() {
        int[][] grid = new int[][]{new int[]{0,1}, new int[]{0,1}, new int[]{0,0}};
        System.out.println("res = " + minFlips(grid));
    }

    public int minFlips(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int a = 0;
        for (int[] row : grid) {
            for (int j = 0; j < n / 2; j++) {
                if (row[j] != row[n - 1 - j]) {
                    a++;
                }
            }
        }
        int b = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                if(grid[j][i] != grid[m - j - 1][i]) {
                    b++;
                }
            }
        }
        return Math.min(a, b);
    }
}

