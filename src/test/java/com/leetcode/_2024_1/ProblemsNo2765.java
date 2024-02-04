package com.leetcode._2024_1;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * 2765. 最长交替子数组
 *
 * @author DHW
 * @date 2024/1/23 9:21
 * @Version 1.0
*/
public class ProblemsNo2765 {

    @Test
    public void solution() {
        int[] nums = new int[]{2,3,4,3,4};
        System.out.println("res = " + alternatingSubarray(nums));
    }

    public int alternatingSubarray(int[] nums) {
        int res = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(n - i <= res) {
                break;
            }
            int j = i + 1;
            int k = 1;
            for (; j < n; j++) {
                if(nums[j] - nums[j-1] == k) {
                    k *= -1;
                    continue;
                }
                break;
            }
            if(j - i > 1) {
                res = Math.max(res, j - i);
            }
        }
        return res;
    }
}

