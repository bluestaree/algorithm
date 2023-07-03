package com.leetcode._2023_6;

import org.junit.Test;


/**
 * 2352. 相等行列对
 *
 * @author DHW
 * @date 2023/6/6 9:06
 * @Version 1.0
*/
public class ProblemsNo2352 {

    @Test
    public void solution() {
        int[][] grid = new int[][]{new int[]{3,2,1}, new int[]{1,7,6}, new int[]{2,7,7}};
        System.out.println("res = " + equalPairs(grid));
    }

    public int equalPairs(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] rows = grid[i];
            for (int j = 0; j < grid.length; j++) {
                boolean mark = true;
                for (int k = 0; k < grid.length; k++) {
                    if(rows[k] != grid[k][j]) {
                        mark = false;
                        break;
                    }
                }
                if(mark) {
                    res++;
                }
            }
        }
        return res;
    }
}
