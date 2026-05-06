package com.leetcode._2026_4;

import org.junit.Test;

import java.text.BreakIterator;
import java.util.Arrays;


/**
 * 240. 搜索二维矩阵 II
 *
 * @author DHW
 * @date 2026/4/2 9:48
 * @Version 1.0
*/
public class ProblemsNo240 {

    @Test
    public void solution() {
        int[][] matrix = new int[][]{new int[]{1, 3, 5, 7, 9},
                                     new int[]{2, 4, 6, 8, 10},
                                     new int[]{11,13,15,17,19},
                                     new int[]{12,14,16,18,20},
                                     new int[]{21,22,23,24,25}};
        int target = 13;
        System.out.println("res = " + searchMatrix(matrix, target));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int x = 0;
        int y = matrix[0].length - 1;
        while (x < matrix.length && y >= 0) {
            if(matrix[x][y] == target) {
                return true;
            }
            if(matrix[x][y] < target) {
                x++;
            } else {
                y--;
            }
        }
        return false;
    }
}
