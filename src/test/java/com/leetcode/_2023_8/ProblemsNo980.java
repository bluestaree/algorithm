package com.leetcode._2023_8;

import org.junit.Test;

import java.util.Arrays;


/**
 * 980. 不同路径 III
 *
 * @author DHW
 * @date 2023/8/4 9:28
 * @Version 1.0
*/
public class ProblemsNo980 {

    @Test
    public void solution() {
        int[][] grid = new int[][]{new int[]{1,2,4}, new int[]{3,3,1}};
        System.out.println("res = " + uniquePathsIII(grid));
    }

    public int uniquePathsIII(int[][] grid) {
        int si = 0 ,sj = 0, count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 0) {
                    count++;
                } else if(grid[i][j] == 1) {
                    si = i;
                    sj = j;
                    count++;
                }
            }
        }
        return dfs(grid, si, sj, count);
    }

    private int dfs(int[][] grid, int si, int sj, int count) {
        if(si < 0 || si >= grid.length || sj < 0 ||  sj >= grid[0].length || grid[si][sj] < 0) {
            return 0;
        }
        if(grid[si][sj] == 2) {
            return count == 0 ? 1 : 0;
        }
        grid[si][sj] = -1;
        int res = dfs(grid, si - 1, sj , count-1) + dfs(grid, si + 1, sj , count-1) + dfs(grid, si, sj - 1, count-1) + dfs(grid, si, sj + 1, count-1);
        grid[si][sj] = 0;
        return res;
    }
}
