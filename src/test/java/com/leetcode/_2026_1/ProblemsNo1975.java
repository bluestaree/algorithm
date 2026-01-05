package com.leetcode._2026_1;

import org.junit.Test;

import java.util.Arrays;


/**
 * 1975. 最大方阵和
 *
 * @author DHW
 * @date 2026/1/5 8:50
 * @Version 1.0
*/
public class ProblemsNo1975 {

    @Test
    public void solution() {
        int[][] matrix = new int[3][3];
        int[] i1 = new int[]{1,1,1};
        int[] i2 = new int[]{1,0,1};
        int[] i3 = new int[]{1,1,1};
        matrix[0] = i1;
        matrix[1] = i2;
        matrix[2] = i3;
        maxMatrixSum(matrix);
        System.out.println("i3 = " + matrix);
    }

    public long maxMatrixSum(int[][] matrix) {
        long ans = 0l;
        int min = Integer.MAX_VALUE;
        int n = matrix.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = Math.abs(matrix[i][j]);
                if (matrix[i][j] < 0) {
                    cnt++;
                }
                min = Math.min(min, num);
                ans += num;
            }
        }
        return cnt % 2 == 0 ? ans : ans - 2 * min;
    }
}
