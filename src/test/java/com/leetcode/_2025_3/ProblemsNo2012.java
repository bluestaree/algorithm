package com.leetcode._2025_3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 2012. 数组美丽值求和
 *
 * @author DHW
 * @date 2025/3/11 8: 46
 * @Version 1.0
*/
public class ProblemsNo2012 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,6};
        System.out.println("res = " + sumOfBeauties(nums));
    }

    public int sumOfBeauties(int[] nums) {
        int res = 0;
        int len = nums.length;
        int leftMax = nums[0];
        int[] rightMin = new int[len];
        rightMin[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i++) {
            rightMin[i] = Math.min(rightMin[i + 1], nums[i]);
        }
        for (int i = 1; i < len - 1; i++) {
            if(nums[i] > leftMax && nums[i] < rightMin[i+1]) {
                res += 2;
            } else if(nums[i] > nums[i-1] && nums[i] < nums[i + 1]) {
                res++;
            }
            leftMax = Math.max(leftMax, nums[i]);
        }
        return res;
    }
}

