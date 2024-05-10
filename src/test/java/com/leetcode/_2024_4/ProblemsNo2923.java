package com.leetcode._2024_4;

import org.junit.Test;


/**
 * 2810. 找到冠军 I
 *
 * @author DHW
 * @date 2024/4/12 8:45
 * @Version 1.0
*/
public class ProblemsNo2923 {

    @Test
    public void solution() {
        int[][] grid = new int[][]{new int[]{0,0,1},new int[]{1,0,1},new int[]{0,0,0}};
        System.out.println("res = " + findChampion(grid));
    }

    public int findChampion(int[][] grid) {
        int cur = 0;
        for (int i = 1; i < grid.length; i++) {
            cur = grid[cur][i] > 0 ? cur : i;
        }
        return cur;
    }

}

