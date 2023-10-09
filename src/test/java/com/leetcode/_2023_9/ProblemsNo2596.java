package com.leetcode._2023_9;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * 2596. 检查骑士巡视方案
 *
 * @author DHW
 * @date 2023/9/13 14:26
 * @Version 1.0
*/
public class ProblemsNo2596 {

    @Test
    public void solution() {
        int[][] grid = new int[][]{new int[]{3,5}, new int[]{2,7}};
        System.out.println("res = " + checkValidGrid(grid));
    }

    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) {
            return false;
        }
        
        int n = grid.length;

        int[][] position = new int[n * n][2];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                position[grid[i][j]] = new int[]{i, j};
            }
        }

        for (int i = 1; i < position.length; i++) {
            int preX = position[i-1][0];
            int preY = position[i-1][1];
            int x = position[i][0];
            int y = position[i][1];
            int absX = Math.abs(preX - x);
            int absY = Math.abs(preY - y);
            if((absX == 2 && absY == 1) || (absX == 1 && absY == 2)) {
                continue;
            }
            return false;
        }

        return true;
    }
}
