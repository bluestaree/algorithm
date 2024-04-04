package com.leetcode._2024_3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;


/**
 * 2684. 矩阵中移动的最大次数
 *
 * @author DHW
 * @date 2024/3/16 11:22
 * @Version 1.0
*/
public class ProblemsNo2684 {

    @Test
    public void solution() {
        int[][] grid = new int[][]{new int[]{0,1}, new int[]{0,2}, new int[]{0,5}, new int[]{0,4}, new int[]{3,2}, new int[]{6,5}};
        System.out.println("res = " + maxMoves(grid));
    }

    int ans = 0;
    Integer[][] memo;

    public int maxMoves(int[][] grid) {
        memo = new Integer[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            dfs(i, 0, 0, Integer.MIN_VALUE, grid);
        }
        return ans;
    }

    private void dfs(int i, int j, int num, int prev, int[][] grid) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] <= prev) {
            return;
        }
        if(memo[i][j] != null && memo[i][j] >= num) {
            return;
        }
        memo[i][j] = num;
        ans = Math.max(ans, num);
        dfs(i-1, j+1, num+1, grid[i][j], grid);
        dfs(i, j+1, num+1, grid[i][j], grid);
        dfs(i+1, j+1, num+1, grid[i][j], grid);
    }

}

