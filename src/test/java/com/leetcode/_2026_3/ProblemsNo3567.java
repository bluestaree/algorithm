package com.leetcode._2026_3;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3567. 子矩阵的最小绝对差
 *
 * @author DHW
 * @date 2026/3/20 8:51
 * @Version 1.0
*/
public class ProblemsNo3567 {

    @Test
    public void solution() {
        int[][] grid = new int[3][3];
        int[] i1 = new int[]{1,1,1};
        int[] i2 = new int[]{1,0,1};
        int[] i3 = new int[]{1,1,1};
        grid[0] = i1;
        grid[1] = i2;
        grid[2] = i3;
        System.out.println("res = " + minAbsDiff(grid, 2));
    }

    public int[][] minAbsDiff(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] ans = new int[n - k + 1][m - k + 1];
        for (int i = 0; i <= n - k; i++) {
            for (int j = 0; j <= m - k; j++) {
                int[] nums = new int[k*k];
                int index = 0;
                for (int l = 0; l < k; l++) {
                    for (int r = 0; r < k; r++) {
                        nums[index++] = grid[l + i][r + j];
                    }
                }
                Arrays.sort(nums);
                int res = Integer.MAX_VALUE;
                for (int l = 1; l < nums.length; l++) {
                    if(nums[l-1] != nums[l]) {
                        res = Math.min(res, nums[l] - nums[l-1]);
                    }
                }
                if(res < Integer.MAX_VALUE) {
                    ans[i][j] = res;
                }
            }
        }
        return ans;
    }
}
