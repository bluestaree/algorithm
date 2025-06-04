package com.leetcode._2025_5;

import org.junit.Test;


/**
 * 3355. 零数组变换 I
 *
 * @author DHW
 * @date 2025/5/20 8: 40
 * @Version 1.0
*/
public class ProblemsNo3355 {

    @Test
    public void solution() {
        int[] nums = new int[]{0,2,1,5,3,4};
        int[][] queries = new int[][]{new int[]{1,2},new int[]{5,6},new int[]{9,10}};
        System.out.println("res = " + isZeroArray(nums, queries));
    }

    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] d = new int[nums.length + 1];
        for (int[] query : queries) {
            d[query[0]]++;
            d[query[1]+1]--;
        }
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            s += d[i];
            if (nums[i] > s) {
                return false;
            }
        }
        return true;
    }
}

