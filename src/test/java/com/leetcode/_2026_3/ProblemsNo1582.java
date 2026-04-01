package com.leetcode._2026_3;

import org.junit.Test;


/**
 * 1582. 二进制矩阵中的特殊位置
 *
 * @author DHW
 * @date 2026/3/4 8:43
 * @Version 1.0
 */
public class ProblemsNo1582 {

    @Test
    public void solution() {
        int[][] mat = new int[][]{new int[]{1, 2}, new int[]{2, 3}};
        System.out.println("res = " + numSpecial(mat));
    }

    public int numSpecial(int[][] mat) {
        int ans = 0;
        for (int[] row : mat) {
            int rowSum = 0;
            int j = -1;
            for (int i = 0; i < row.length; i++) {
                if (row[i] == 1) {
                    rowSum++;
                    j = i;
                }
            }
            if (rowSum != 1) {
                continue;
            }

            int colSum = 0;
            for (int[] r : mat) {
                colSum += r[j];
            }
            if (colSum == 1) {
                ans++;
            }
        }
        return ans;
    }
}
