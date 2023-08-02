package com.leetcode._2023_7;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2679. 矩阵中的和
 *
 * @author DHW
 * @date 2023/7/4 9:18
 * @Version 1.0
*/
public class ProblemsNo2679 {

    @Test
    public void solution() {
        int[][] nums = new int[][]{new int[]{1,8,16,15,12,9,15,11,18,6,16,4,9,4}
        , new int[]{3,19,8,17,19,4,9,3,2,10,15,17,3,11}
        , new int[]{13,10,19,20,6,17,15,14,16,8,1,17,0,2}
        , new int[]{12,20,0,19,15,10,7,10,2,6,18,7,7,4}
        , new int[]{17,14,2,2,10,16,15,3,9,17,9,3,17,10}
        , new int[]{17,6,19,17,18,9,14,2,19,12,10,18,7,9}
        , new int[]{5,6,5,1,19,8,15,2,2,4,4,1,2,17}
        };
        System.out.println("res = " + matrixSum(nums));
    }

    public int matrixSum(int[][] nums) {
        int res = 0;
        int rows = nums.length;
        int cols = nums[0].length;
        for (int i = 0; i < nums.length; i++) {
            Arrays.sort(nums[i]);
        }

        for (int i = 0; i < cols; i++) {
            int maxNum = 0;
            for (int j = 0; j < rows; j++) {
                maxNum = Math.max(maxNum, nums[j][i]);
            }
            res += maxNum;
        }
        return res;
    }
}
