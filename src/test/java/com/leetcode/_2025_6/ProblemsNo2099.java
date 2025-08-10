package com.leetcode._2025_6;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * 2099. 找到和最大的长度为 K 的子序列
 *
 * @author DHW
 * @date 2025/6/28 10: 08
 * @Version 1.0
*/
public class ProblemsNo2099 {

    @Test
    public void solution() {
        int[] nums = new int[]{3,4,3,3};
        int k = 2;
        System.out.println("res = " + maxSubsequence(nums, k));
    }

    public int[] maxSubsequence(int[] nums, int k) {
        int[] ans = new int[k];
        int n = nums.length;
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (a,b) -> nums[b] - nums[a]);
        Arrays.sort(index, 0, k);
        for (int i = 0; i < ans.length; i++) {
            ans[i] = nums[index[i]];
        }
        return ans;
    }
}

