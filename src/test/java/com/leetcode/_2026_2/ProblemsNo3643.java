package com.leetcode._2026_2;

import org.junit.Test;


/**
 * 3643. 垂直翻转子矩阵
 *
 * @author DHW
 * @date 2026/2/25 9:21
 * @Version 1.0
 */
public class ProblemsNo3643 {

    @Test
    public void solution() {
        int[][] grid = new int[][]{new int[]{1, 2}, new int[]{2, 3}};
        int x = 0, y = 0, k = 2;
        System.out.println("res = " + reverseSubmatrix(grid, x, y, k));
    }

    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int l = x, r = x + k - 1;
        while(l < r) {
            for(int i = y; i < y + k; i++) {
                int temp = grid[l][i];
                grid[l][i] = grid[r][i];
                grid[r][i] = temp;
            }
            l++;
            r--;
        }
        return grid;
    }
}
