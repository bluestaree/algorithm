package com.leetcode._2025_5;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


/**
 * 1920. 基于排列构建数组
 *
 * @author DHW
 * @date 2025/5/6 9: 13
 * @Version 1.0
*/
public class ProblemsNo1920 {

    @Test
    public void solution() {
        int[] nums = new int[]{0,2,1,5,3,4};
        System.out.println("res = " + buildArray(nums));
    }

    public int[] buildArray(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[nums[i]];
        }
        return res;
    }
}

