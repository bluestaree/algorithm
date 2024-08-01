package com.leetcode._2024_7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 3033. 修改矩阵
 *
 * @author DHW
 * @date 2024/7/5 9:09
 * @Version 1.0
*/
public class ProblemsNo3033 {

    @Test
    public void solution() {
        int[][] matrix = new int[][]{new int[]{-1,0,0,2,2},new int[]{2,0,0,2,1},new int[]{4,3,2,1,1},new int[]{-1,-1,0,2,4},new int[]{1,0,3,-1,0}};
        System.out.println("res = " + modifiedMatrix(matrix));
    }

    public int[][] modifiedMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < n; i++) {
            int maxNum = 0;
            for (int j = 0; j < m; j++) {
                maxNum = Math.max(maxNum, matrix[j][i]);
            }
            for (int j = 0; j < m; j++) {
                if(matrix[j][i] == -1) {
                    matrix[j][i] = maxNum;
                }
            }
        }
        return matrix;
    }
}

