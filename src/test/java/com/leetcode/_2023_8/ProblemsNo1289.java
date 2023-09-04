package com.leetcode._2023_8;

import org.junit.Test;


/**
 * 1289. 下降路径最小和 II
 *
 * @author DHW
 * @date 2023/8/10 8:51
 * @Version 1.0
*/
public class ProblemsNo1289 {

    @Test
    public void solution() {
        int[][] grid = new int[][]{new int[]{1,2,3}, new int[]{4,5,6}, new int[]{7,8,9}};
        System.out.println("res = " + minFallingPathSum(grid));
    }

    public int minFallingPathSum(int[][] grid) {
        int preMinNum = 0;
        int preSecondMinNum = 0;
        int preMinIndex = -1;
        int len = grid.length;

        for (int i = 0; i < len; i++) {
            int curMinNum = Integer.MAX_VALUE;
            int curSecondMinNum = Integer.MAX_VALUE;
            int curMinIndex = -1;

            for (int j = 0; j < len; j++) {
                int num = (j != preMinIndex ? preMinNum : preSecondMinNum) + grid[i][j];
                if(num < curMinNum) {
                    curSecondMinNum = curMinNum;
                    curMinNum = num;
                    curMinIndex = j;
                } else if(num < curSecondMinNum) {
                    curSecondMinNum = num;
                }
            }
            preMinNum = curMinNum;
            preSecondMinNum = curSecondMinNum;
            preMinIndex = curMinIndex;
        }
        return preMinNum;
    }

}
