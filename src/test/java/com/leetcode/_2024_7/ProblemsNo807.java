package com.leetcode._2024_7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 807. 保持城市天际线
 *
 * @author DHW
 * @date 2024/7/14 9:43
 * @Version 1.0
*/
public class ProblemsNo807 {

    @Test
    public void solution() {
        int[][] grid = new int[][]{new int[]{0,1,10},new int[]{1,2,15},new int[]{0,3,10}};
        System.out.println("res = " + maxIncreaseKeepingSkyline(grid));
    }


    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] maxCol = new int[n];
        int[] maxRow = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxRow[i] = Math.max(maxRow[i], grid[i][j]);
                maxCol[j] = Math.max(maxCol[j], grid[i][j]);
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res += Math.min(maxRow[i], maxCol[j]) - grid[i][j];
            }
        }
        return res;
    }
}

