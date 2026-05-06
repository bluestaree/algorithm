package com.leetcode._2026_5;

import org.junit.Test;

import java.util.Arrays;


/**
 * 1861. 旋转盒子
 *
 * @author DHW
 * @date 2026/5/6 8:48
 * @Version 1.0
 */
public class ProblemsNo1861 {

    @Test
    public void solution() {
        char[][] grid = new char[2][2];
        char[] i1 = new char[]{'.','X'};
        char[] i2 = new char[]{'.','Y'};
        grid[0] = i1;
        grid[1] = i2;
        System.out.println("res = " + rotateTheBox(grid));
    }

    public char[][] rotateTheBox(char[][] boxGrid) {
        int n = boxGrid.length;
        int m = boxGrid[0].length;
        char[][] ans = new char[m][n];
        for (char[] row : ans) {
            Arrays.fill(row, '.');
        }

        for (int i = 0; i < n; i++) {
            int k = m - 1;
            for (int j = m - 1; j >= 0; j--) {
                if(boxGrid[i][j] == '*') {
                    ans[j][n - 1 - i] = '*';
                    k = j - 1;
                } else if(boxGrid[i][j] == '#') {
                    ans[k][n - 1 - i] = '#';
                    k--;
                }
            }
        }
        return ans;
    }
}
