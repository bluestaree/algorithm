package com.leetcode._2025_6;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * 2966. 划分数组并满足最大差限制
 *
 * @author DHW
 * @date 2025/6/18 8: 38
 * @Version 1.0
*/
public class ProblemsNo2966 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,3,4,8,7,9,3,5,1};
        int k = 2;
        System.out.println("res = " + divideArray(nums, k));
    }

    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        int[][] res = new int[n/3][3];
        Arrays.sort(nums);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = nums[i * 3 + j];
            }
            if(res[i][2] - res[i][0] > k) {
                return new int[0][0];
            }
        }
        return res;
    }
}

