package com.leetcode._2025_2;

import org.junit.Test;


/**
 * 59. 螺旋矩阵 II
 *
 * @author DHW
 * @date 2025/2/7 8:37
 * @Version 1.0
 */
public class ProblemsNo59 {

    @Test
    public void solution() {

        int n = 2;
        System.out.println("res = " + generateMatrix(n));
    }

    public int[][] generateMatrix(int n) {
        int[][] grid = new int[n][n];
        int[] dirs = {0, 1, 0, -1, 0};
        int i = 0;
        int j = 0;
        int k = 0;
        for (int v = 1; v <= n * n; v++) {
            grid[i][j] = v;
            int x = i + dirs[k];
            int y = j + dirs[k+1];
            if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] != 0) {
                k = (k + 1) % 4;
            }
            i += dirs[k];
            j += dirs[k + 1];
        }
        return grid;
    }
}
