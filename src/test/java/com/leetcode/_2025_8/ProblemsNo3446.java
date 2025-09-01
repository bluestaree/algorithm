package com.leetcode._2025_8;

import org.junit.Test;

import java.util.ArrayList;


/**
 * 3446.按对角线进行矩阵排序
 *
 * @author DHW
 * @date 2025/8/28 9: 22
 * @Version 1.0
*/
public class ProblemsNo3446 {

    @Test
    public void solution() {
        int[][] grid =  new int[][]{new int[]{1,7,3},new int[]{9,8,2},new int[]{4,5,6}};
        System.out.println("res = " + sortMatrix(grid));
    }

    public int[][] sortMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int k = 0; k < m + n - 1; k++) {
            int i = k < m ? k : 0;
            int j = k < m ? 0 : k - m + 1;
            ArrayList<Integer> temp = new ArrayList<>();
            while (i < m && j < n) {
                temp.add(grid[i++][j++]);
            }
            if(k < m) {
                temp.sort((x, y) -> x - y);
            } else {
                temp.sort((x, y) -> y - x);
            }
            for (Integer num : temp) {
                grid[--i][--j] = num;
            }
        }
        return grid;
    }
}

