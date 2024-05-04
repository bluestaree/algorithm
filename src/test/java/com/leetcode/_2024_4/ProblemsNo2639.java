package com.leetcode._2024_4;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;


/**
 * 2639. 查询网格图中每一列的宽度
 *
 * @author DHW
 * @date 2024/4/27 11:02
 * @Version 1.0
*/
public class ProblemsNo2639 {

    @Test
    public void solution() {
        int[][] grid = new int[][]{new int[]{1}, new int[]{2}, new int[]{3}};
        System.out.println("res = " + findColumnWidth(grid));
    }

    public int[] findColumnWidth(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i] = Math.max(res[i], Integer.toString(grid[j][i]).length());
            }
        }
        return res;
    }

}

