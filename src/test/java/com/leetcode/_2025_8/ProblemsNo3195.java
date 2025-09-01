package com.leetcode._2025_8;

import org.junit.Test;


/**
 * 3195.包含所有 1 的最小矩形面积 I
 *
 * @author DHW
 * @date 2025/8/22 9: 08
 * @Version 1.0
*/
public class ProblemsNo3195 {

    @Test
    public void solution() {
        int[][] grid =  new int[][]{new int[]{0,1,1,0},new int[]{0,1,1,1},new int[]{1,1,1,0}};
        System.out.println("res = " + minimumArea(grid));
    }

    public int minimumArea(int[][] grid) {
        int minX = Integer.MAX_VALUE;
        int maxX = 0;
        int minY = Integer.MAX_VALUE;
        int maxY = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    minX = Math.min(minX, i);
                    maxX = Math.max(maxX, i);
                    minY = Math.min(minY, j);
                    maxY = Math.max(maxY, j);
                }
            }
        }
        int a = maxX - minX + 1;
        int b = maxY - minY + 1;
        return a * b;
    }
}

