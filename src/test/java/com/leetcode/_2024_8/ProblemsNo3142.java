package com.leetcode._2024_8;

import org.junit.Test;


/**
 * 3142. 判断矩阵是否满足条件
 *
 * @author DHW
 * @date 2024/8/29 9:15
 * @Version 1.0
*/
public class ProblemsNo3142 {

    @Test
    public void solution() {
        int[][] grid = new int[][]{new int[]{0,1},new int[]{1,2},new int[]{0,3}};
        System.out.println("res = " + satisfiesConditions(grid));
    }

    public boolean satisfiesConditions(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(i+1 < grid.length && grid[i][j] != grid[i + 1][j]) {
                    return false;
                }
                if(j+1 < grid[i].length && grid[i][j] == grid[i][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}

