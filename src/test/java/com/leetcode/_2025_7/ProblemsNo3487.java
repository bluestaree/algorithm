package com.leetcode._2025_7;

import org.junit.Test;

import java.util.HashSet;


/**
 * 3487. 删除后的最大子数组元素和
 *
 * @author DHW
 * @date 2025/7/25 9: 50
 * @Version 1.0
*/
public class ProblemsNo3487 {

    @Test
    public void solution() {
        int[] nums =  new int[]{2,5};
        System.out.println("res = " + maxSum(nums));
    }

    public int maxSum(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        Integer s = null;

        int mx = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < 0) {
                mx = Math.max(mx, nums[i]);
            }
            if(set.add(nums[i]) && nums[i] >= 0) {
                if(s == null) {
                    s = 0;
                }
                s += nums[i];
            }
        }
        if(s == null) {
            return mx;
        }
        return s;
    }

}

