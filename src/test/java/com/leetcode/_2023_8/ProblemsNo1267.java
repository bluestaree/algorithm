package com.leetcode._2023_8;

import org.junit.Test;


/**
 * 1267. 统计参与通信的服务器
 *
 * @author DHW
 * @date 2023/8/24 10:02
 * @Version 1.0
*/
public class ProblemsNo1267 {

    @Test
    public void solution() {
        int[][] grid = new int[][]{new int[]{1,0,0}, new int[]{1,0,0}};
        System.out.println("res = " + countServers(grid));
    }

    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1 && (row[i] > 1 || col[j] > 1)) {
                    ++ans;
                }
            }
        }
        return ans;
    }

}
