package com.leetcode._2025_2;

import org.junit.Test;


/**
 * 1706. 球会落何处
 *
 * @author DHW
 * @date 2025/2/15 10: 58
 * @Version 1.0
*/
public class ProblemsNo1706 {

    @Test
    public void solution() {
        int[][] grid = new int[][]{new int[]{1,1,1,1,1,1},new int[]{-1,-1,-1,-1,-1,-1},new int[]{1,1,1,1,1,1},new int[]{-1,-1,-1,-1,-1,-1}};
        System.out.println("res = " + findBall(grid));
    }

    int m;
    int n;
    int[][] grid;
    public int[] findBall(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = dfs(0, i);
        }
        return res;
    }

    private int dfs(int i, int j) {
        if(i == m) {
            return j;
        }
        if(j == 0 && grid[i][j] == -1) {
            return -1;
        }
        if(j == n - 1 && grid[i][j] == 1) {
            return -1;
        }
        if(grid[i][j] == 1 && grid[i][j + 1] == -1 ) {
            return -1;
        }
        if(grid[i][j] == -1 && grid[i][j - 1] == 1 ) {
            return -1;
        }
        return grid[i][j] == 1 ? dfs(i + 1, j + 1) : dfs(i + 1, j - 1);
    }
}

