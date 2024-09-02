package com.leetcode._2024_8;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3151. 特殊数组 I
 *
 * @author DHW
 * @date 2024/8/13 9:00
 * @Version 1.0
*/
public class ProblemsNo3151 {

    @Test
    public void solution() {
        int[] nums = new int[]{7,4,1};
        System.out.println("res = " + isArraySpecial(nums));
    }

    public boolean isArraySpecial(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if(nums[i-1] % 2 == nums[i] % 2) {
                return false;
            }
        }
        return true;
    }
}

