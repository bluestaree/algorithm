package com.leetcode._2023_1;

import org.junit.Test;


/**
 * 2319. 判断矩阵是否是一个 X 矩阵
 *
 * @author DHW
 * @date 2023/1/31 10:00
 * @Version 1.0
*/
public class ProblemsNo2319 {

    @Test
    public void solution() {
        int[][] grid = new int[][]{new int[]{2,0,0,1},new int[]{0,3,1,0},new int[]{0,5,2,0},new int[]{4,0,0,2}};
        System.out.println("res = " + checkXMatrix(grid));
    }

    public boolean checkXMatrix(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            int[] rows = grid[i];
            for (int j = 0; j < rows.length; j++) {
                if(i == j || rows.length - 1 == j + i) {
                    if(rows[j] == 0) {
                        return false;
                    }
                } else if(rows[j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
