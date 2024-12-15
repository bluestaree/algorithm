package com.leetcode._2024_11;

import org.junit.Test;


/**
 * 3242. 设计相邻元素求和服务
 *
 * @author DHW
 * @date 2024/11/9 10: 29
 * @Version 1.0
 */
public class ProblemsNo3242 {

    @Test
    public void solution() {
        NeighborSum obj = new NeighborSum(new int[][]{new int[]{0, 1, 2}, new int[]{3, 4, 5}, new int[]{6, 7, 8}});
        int param_1 = obj.adjacentSum(1);
        int param_2 = obj.diagonalSum(4);
    }

    class NeighborSum {
        int[][] grid;
        int[][] a;

        public NeighborSum(int[][] grid) {
            int n = grid.length;
            this.grid = new int[n + 2][n + 2];
            a = new int[n * n][2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[grid[i][j]] = new int[]{i, j};
                    this.grid[i + 1][j + 1] = grid[i][j];
                }
            }
        }

        public int adjacentSum(int value) {
            int[] pos = a[value];
            int x = pos[0] + 1;
            int y = pos[1] +1;
            return grid[x - 1][y] + grid[x + 1][y] + grid[x][y + 1] + grid[x][y - 1];
        }

        public int diagonalSum(int value) {
            int[] pos = a[value];
            int x = pos[0] + 1;
            int y = pos[1]+1;
            return grid[x - 1][y + 1] + grid[x - 1][y - 1] + grid[x + 1][y + 1] + grid[x + 1][y - 1];
        }
    }
}

