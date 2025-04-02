package com.leetcode._2025_3;

import org.junit.Test;

import java.util.HashSet;


/**
 * 2711. 对角线上不同值的数量差
 *
 * @author DHW
 * @date 2025/3/25 9: 04
 * @Version 1.0
*/
public class ProblemsNo2711 {

    @Test
    public void solution() {
        int[][] grid = new int[][]{new int[]{1,2,3},new int[]{5,6,7},new int[]{9,10,11}};
        System.out.println("res = " + differenceOfDistinctValues(grid));
    }

    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int a = i;
                int b = j;
                HashSet<Integer> s = new HashSet<>();
                while(a > 0 && b > 0 ) {
                    s.add(grid[--a][--b]);
                }
                int tl = s.size();
                s.clear();
                a = i;
                b = j;
                while(a < m - 1 && b < n - 1) {
                    s.add(grid[++a][++b]);
                }
                int br = s.size();
                res[i][j] = Math.abs( tl -  br);
            }
        }
        return res;
    }
}

