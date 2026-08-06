package com.leetcode._2026_7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * 1260. 二维网格迁移
 *
 * @author DHW
 * @date 2026/7/20 10:50
 * @Version 1.0
*/
public class ProblemsNo1260 {

    @Test
    public void solution() {
        int[][] grid = new int[][]{new int[]{3, 3, 1, 1}, new int[]{2, 2, 1, 2}, new int[]{1, 1, 1, 2}};
        System.out.println("res = " + shiftGrid(grid, 9));
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            ans.add(new ArrayList<>(Collections.nCopies(n, 0)));
        }

        int size = m * n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int p = (i * n + j + k) % size;
                ans.get(p / n).set(p % n, grid[i][j]);
            }
        }

        return ans;
    }
}

