package com.leetcode._2026_10;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3619. 总价值可以被 K 整除的岛屿数目
 *
 * @author DHW
 * @date 2026/10/26 9:19
 * @Version 1.0
*/
public class ProblemsNo3619 {

    @Test
    public void solution() {
        int[][] grid = new int[][]{new int[]{1,2}, new int[]{2,3}};
        int x = 2;
        System.out.println("res = " + countIslands(grid, x));
    }

    int[][] directions = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};

    public int countIslands(int[][] grid, int k) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] > 0) {
                    long res = dfs(grid, i, j);
                    if(res % k == 0) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    private long dfs(int[][] grid, int i, int j) {
        long res = grid[i][j];
        grid[i][j] = 0;
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if(x >= 0 && x < grid.length && y >= 0 && y < grid[x].length && grid[x][y] > 0) {
                res += dfs(grid, x, y);
            }
        }
        return res;
    }
}
