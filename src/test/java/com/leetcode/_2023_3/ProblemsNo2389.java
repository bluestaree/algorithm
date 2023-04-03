package com.leetcode._2023_3;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2389. 和有限的最长子序列
 *
 * @author DHW
 * @date 2023/3/17 9:58
 * @Version 1.0
*/
public class ProblemsNo2389 {

    @Test
    public void solution() {
        int[] nums = new int[]{736411,184882,914641,37925,214915};
        int[] queries = new int[]{331244,273144,118983,118252,305688,718089,665450};
        System.out.println("res = " + answerQueries(nums, queries));
    }

    public int[] answerQueries(int[] nums, int[] queries) {
        int m = queries.length;
        int n = nums.length;

        Arrays.sort(nums);
        int[] res = new int[m];
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i-1];
        }

        for (int i = 0; i < m; i++) {
            res[i] = binary(nums, queries[i]);
        }
        return res;
    }

    private int binary(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
