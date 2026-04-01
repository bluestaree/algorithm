package com.leetcode._2026_3;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3546. 等和矩阵分割 I
 *
 * @author DHW
 * @date 2026/3/25 8:51
 * @Version 1.0
*/
public class ProblemsNo3546 {

    @Test
    public void solution() {
        int[][] grid = new int[3][3];
        int[] i1 = new int[]{1,1,1};
        int[] i2 = new int[]{1,0,1};
        int[] i3 = new int[]{1,1,1};
        grid[0] = i1;
        grid[1] = i2;
        grid[2] = i3;
        System.out.println("res = " + canPartitionGrid(grid));
    }

    public boolean canPartitionGrid(int[][] grid) {
        long total = 0;
        for (int[] ints : grid) {
            for (int anInt : ints) {
                total += anInt;
            }
        }
        return canPartitionX(grid, total) || canPartitionY(grid, total);
    }

    private boolean canPartitionX(int[][] grid, long total) {
        long s = 0;
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                s += grid[i][j];
            }
            if(s * 2 == total) return true;
        }
        return false;
    }

    private boolean canPartitionY(int[][] grid, long total) {
        long s = 0;
        for (int i = 0; i < grid[0].length - 1; i++) {
            for (int j = 0; j < grid.length; j++) {
                s += grid[j][i];
            }
            if(s * 2 == total) return true;
        }
        return false;
    }
}
