package com.leetcode._2026_10;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3128. 直角三角形
 *
 * @author DHW
 * @date 2026/10/27 9:19
 * @Version 1.0
*/
public class ProblemsNo3128 {

    @Test
    public void solution() {
        int[][] grid = new int[][]{new int[]{1,2}, new int[]{2,3}};
        System.out.println("res = " + numberOfRightTriangles(grid));
    }


    public long numberOfRightTriangles(int[][] grid) {
        int n = grid[0].length;
        int[] colSum = new int[n];
        Arrays.fill(colSum, -1);
        for (int[] rows : grid) {
            for (int j = 0; j < n; j++) {
                colSum[j] += rows[j];
            }
        }

        long ans = 0;

        for (int[] rows : grid) {
            int rowSum = -1;
            for (int row : rows) {
                rowSum += row;
            }
            for (int i = 0; i < n; i++) {
                if (rows[i] == 1) {
                    ans += rowSum * colSum[i];
                }
            }
        }
        return ans;
    }
}
