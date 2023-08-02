package com.leetcode._2023_7;

import org.junit.Test;

import java.util.*;


/**
 * 2500. 删除每行中的最大值
 *
 * @author DHW
 * @date 2023/7/27 8:47
 * @Version 1.0
*/
public class ProblemsNo2500 {

    @Test
    public void solution() {
        int[][] grid = new int[][]{new int[]{1,2,4}, new int[]{3,3,1}};
        System.out.println("res = " + deleteGreatestValue(grid));
    }

    public int deleteGreatestValue(int[][] grid) {
        int res = 0, maxNum = 0;
        for (int i = 0; i < grid.length; i++) {
            Arrays.sort(grid[i]);
        }

        for (int i = 0; i < grid[0].length; i++) {
            maxNum = 0;
            for (int j = 0; j < grid.length; j++) {
                maxNum = Math.max(grid[j][i], maxNum);
            }
            res += maxNum;
        }
        return res;
    }
}
