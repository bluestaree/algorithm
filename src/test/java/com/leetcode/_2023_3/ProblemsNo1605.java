package com.leetcode._2023_3;

import org.junit.Test;


/**
 * 1605. 给定行和列的和求可行矩阵
 *
 * @author DHW
 * @date 2023/3/14 9:54
 * @Version 1.0
*/
public class ProblemsNo1605 {

    @Test
    public void solution() {
        int[] rowSum = new int[]{};
        int[] colSum = new int[]{};
        System.out.println("res = " + restoreMatrix(rowSum, colSum));
    }

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int row = rowSum.length;
        int col = colSum.length;
        int[][] res = new int[row][col];
        for (int i = 0; i < rowSum.length; i++) {
            for (int j = 0; j < colSum.length; j++) {
                res[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= res[i][j];
                colSum[j] -= res[i][j];
            }
        }
        return res;
    }
}
