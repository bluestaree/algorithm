package com.leetcode._2026_3;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3070. 元素和小于等于 k 的子矩阵的数目
 *
 * @author DHW
 * @date 2026/3/18 9:37
 * @Version 1.0
*/
public class ProblemsNo3070 {

    @Test
    public void solution() {
        int[][] grid = new int[3][3];
        int[] i1 = new int[]{1,1,1};
        int[] i2 = new int[]{1,0,1};
        int[] i3 = new int[]{1,1,1};
        grid[0] = i1;
        grid[1] = i2;
        grid[2] = i3;
        System.out.println("res = " + countSubmatrices(grid, 2));
    }

    public int countSubmatrices(int[][] grid, int k) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] s = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                s[i+1][j+1] = s[i+1][j] + s[i][j+1] - s[i][j] + grid[i][j];
                if (s[i+1][j+1] <= k) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
