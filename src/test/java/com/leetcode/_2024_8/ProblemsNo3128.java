package com.leetcode._2024_8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 3128. 直角三角形
 *
 * @author DHW
 * @date 2024/8/2 9:15
 * @Version 1.0
*/
public class ProblemsNo3128 {

    @Test
    public void solution() {
        int[][] grid = new int[][]{new int[]{0,1,10},new int[]{1,2,15},new int[]{0,3,10}};
        System.out.println("res = " + numberOfRightTriangles(grid));
    }

    public long numberOfRightTriangles(int[][] grid) {
        long res = 0;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int[] countRows = new int[rowLen];
        int[] countCols = new int[colLen];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if(grid[i][j] == 1) {
                    countRows[i]++;
                    countCols[j]++;
                }
            }
        }
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if(grid[i][j] == 1) {
                    res += (countRows[i]-1) * (countCols[j]-1);
                }
            }
        }
        return res;
    }
}

