package com.leetcode._2024_8;

import org.junit.Test;


/**
 * 3152. 特殊数组 II
 *
 * @author DHW
 * @date 2024/8/14 9:15
 * @Version 1.0
*/
public class ProblemsNo3152 {

    @Test
    public void solution() {
        int[] nums = new int[]{7,4,1};
        int[][] grid = new int[][]{new int[]{0,1},new int[]{1,2},new int[]{0,3}};
        System.out.println("res = " + isArraySpecial(nums, grid));
    }

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int len = nums.length;
        int[] a = new int[len];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i-1] % 2 != nums[i] % 2) {
                a[i] = a[i-1] + 1;
            }
        }
        len = queries.length;
        boolean[] b = new boolean[len];
        for (int i = 0; i < len; i++) {
            int[] query = queries[i];
            b[i] = a[query[1]] - a[query[0]] == query[1] - query[0];
        }
        return b;
    }
}

