package com.leetcode._2026_4;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2033. 获取单值网格的最小操作数
 *
 * @author DHW
 * @date 2026/4/28 9:19
 * @Version 1.0
*/
public class ProblemsNo2033 {

    @Test
    public void solution() {
        int[][] grid = new int[][]{new int[]{1,2}, new int[]{2,3}};
        int x = 2;
        System.out.println("res = " + minOperations(grid, x));
    }

    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;
        int k = n * m;
        int[] arr = new int[k];
        int t = grid[0][0] % x;
        int i = 0;
        for (int[] nums : grid) {
            for (int num : nums) {
                if(num % x != t) {
                    return -1;
                }
                arr[i++] = num;
            }
        }

        Arrays.sort(arr);
        int median = arr[k / 2];

        int ans = 0;
        for (int num : arr) {
            ans += Math.abs(num - median);
        }

        return ans / x;
    }
}
