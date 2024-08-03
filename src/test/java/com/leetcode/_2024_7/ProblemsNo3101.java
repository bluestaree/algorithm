package com.leetcode._2024_7;

import org.junit.Test;


/**
 * 3101. 交替子数组计数
 *
 * @author DHW
 * @date 2024/7/6 10:30
 * @Version 1.0
*/
public class ProblemsNo3101 {

    @Test
    public void solution() {
        int[] nums = new int[]{0,1,1,1};
        System.out.println("res = " + countAlternatingSubarrays(nums));
    }

    public long countAlternatingSubarrays(int[] nums) {
        long num = 1;
        long s = 1;
        for (int i = 1; i < nums.length; i++) {
            s = nums[i] == nums[i-1] ? 1 : s + 1;
            num += s;
        }
        return num;
    }
}

