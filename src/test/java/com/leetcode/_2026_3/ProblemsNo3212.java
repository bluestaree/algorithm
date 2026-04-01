package com.leetcode._2026_3;

import org.junit.Test;

import java.util.HashMap;


/**
 * 3212. 统计 X 和 Y 频数相等的子矩阵数量
 *
 * @author DHW
 * @date 2026/3/18 9:28
 * @Version 1.0
 */
public class ProblemsNo3212 {

    @Test
    public void solution() {
        char[][] grid = new char[2][2];
        char[] i1 = new char[]{'.','X'};
        char[] i2 = new char[]{'.','Y'};
        grid[0] = i1;
        grid[1] = i2;
        System.out.println("res = " + numberOfSubmatrices(grid));
    }

    public int numberOfSubmatrices(char[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][][] s = new int[n + 1][m + 1][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                s[i + 1][j + 1][0] = s[i + 1][j][0] + s[i][j + 1][0] - s[i][j][0];
                s[i + 1][j + 1][1] = s[i + 1][j][1] + s[i][j + 1][1] - s[i][j][1];
                if(grid[i][j] != '.') {
                    s[i + 1][j + 1][grid[i][j] & 1]++;
                }
                if(s[i + 1][j + 1][0] > 0  &&  s[i + 1][j + 1][1] == s[i + 1][j + 1][0]) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
