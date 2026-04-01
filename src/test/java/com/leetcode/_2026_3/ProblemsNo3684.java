package com.leetcode._2026_3;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3684. 至多 K 个不同元素的最大和
 *
 * @author DHW
 * @date 2026/3/30 10: 20
 * @Version 1.0
 */
public class ProblemsNo3684 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,1,1,2,2,2};
        int k = 6;
        System.out.println("res = " + maxKDistinct(nums, k));
    }

    public int[] maxKDistinct(int[] nums, int k) {
        int[] temp = new int[k];
        Arrays.sort(nums);
        int idx = 0;
        for (int i = nums.length - 1; i >= 0 && idx < k; i--) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            temp[idx++] = nums[i];
        }
        int len = Math.min(idx, k);
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = temp[i];
        }
        return ans;
    }

}

