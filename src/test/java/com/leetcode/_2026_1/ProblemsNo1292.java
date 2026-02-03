package com.leetcode._2026_1;

import org.junit.Test;

import java.util.Arrays;


/**
 * 1292. 元素和小于等于阈值的正方形的最大边长
 *
 * @author DHW
 * @date 2026/1/19 8:49
 * @Version 1.0
*/
public class ProblemsNo1292 {

    @Test
    public void solution() {
        int[][] matrix = new int[3][3];
        int[] i1 = new int[]{1,1,1};
        int[] i2 = new int[]{1,0,1};
        int[] i3 = new int[]{1,1,1};
        matrix[0] = i1;
        matrix[1] = i2;
        matrix[2] = i3;
        int threshold = 2;
        maxSideLength(matrix, threshold);
        System.out.println("i3 = " + matrix);
    }

    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = ans + 1; k <= Math.min(m - i + 1, n - j + 1); k++) {
                    int total = sum[i + k - 1][j + k - 1] - sum[i - 1][j + k - 1] - sum[i + k - 1][j - 1] + sum[i - 1][j - 1];
                    if (total <= threshold) {
                        ans = k;
                    } else {
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
