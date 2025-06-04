package com.leetcode._2025_5;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3024. 三角形类型
 *
 * @author DHW
 * @date 2025/5/19 9: 39
 * @Version 1.0
*/
public class ProblemsNo3024 {

    @Test
    public void solution() {
        int[] nums = new int[]{3,2,1};
        System.out.println("res = " + triangleType(nums));
    }

    public String triangleType(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] + nums[1] <= nums[2]) {
            return "none";
        }
        if (nums[0] == nums[2]) {
            return "equilateral";
        }
        if (nums[0] == nums[1] || nums[1] == nums[2]) {
            return "isosceles";
        }
        return "scalene";
    }
}

