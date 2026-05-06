package com.leetcode._2026_4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;


/**
 * 1391. 检查网格中是否存在有效路径
 *
 * @author DHW
 * @date 2023/1/14 9:39
 * @Version 1.0
 */
public class ProblemsNo1391 {

    @Test
    public void solution() {
        int[][] grid = new int[][]{new int[]{0,2}, new int[]{5,10}, new int[]{13,23}, new int[]{24,25}};
        System.out.println("res = " + hasValidPath(grid));
    }

    int[][][] dirs = new int[][][]{
            new int[][]{},
            new int[][]{{0,1},{0,-1}},
            new int[][]{{1,0},{-1,0}},
            new int[][]{{1,0},{-1,0}},
            new int[][]{{0,-1},{1,0}},
            new int[][]{{0,-1},{-1,0}},
            new int[][]{{-1,0},{0,1}}
    };

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        return dfs(0, 0, grid, vis);
    }

    private boolean dfs(int x, int y, int[][] grid, boolean[][] vis) {
        int m = grid.length;
        int n = grid[x].length;
        if (x == m - 1 && y == n - 1) {
            return true;
        }
        vis[x][y] = true;
        for (int[] dir : dirs[grid[x][y]]) {
            int i = dir[0] + x;
            int j = dir[1] + y;

            if(i >= 0 && i < m && j >= 0 && j < n && !vis[i][j]
            && checkPass(grid[i][j], -dir[0], -dir[1]) && dfs(i, j, grid, vis)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkPass(int street, int i, int j) {
        int[][] dir = dirs[street];
        return (dir[0][0] == i && dir[0][1] == j) || (dir[1][0] == i && dir[1][1] == j);
    }
}
