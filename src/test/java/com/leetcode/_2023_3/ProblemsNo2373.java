package com.leetcode._2023_3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/**
 * 2373. 矩阵中的局部最大值
 *
 * @author DHW
 * @date 2023/3/1 9:21
 * @Version 1.0
*/
public class ProblemsNo2373 {

    @Test
    public void solution() {
        int[][] grid = new int[][]{new int[]{1,2}, new int[]{2,3}};
        System.out.println("res = " + largestLocal(grid));
    }

    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n - 2][n - 2];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = findMax(i+1, j+1, grid);
            }
        }
        return res;
    }

    private int findMax(int x, int y, int[][] grid) {
        int num = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                num = Math.max(grid[i][j], num);
            }
        }
        return num;
    }
}
