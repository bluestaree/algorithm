package com.leetcode._2024_10;

import org.junit.Test;

import java.util.HashSet;


/**
 * 3191. 使二进制数组全部等于 1 的最少操作次数 I
 *
 * @author DHW
 * @date 2024/10/18 9:34
 * @Version 1.0
*/
public class ProblemsNo3191 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,8,2,8};
        System.out.println("res = " + minOperations(nums));
    }

    public int minOperations(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                if(i + 2 >= nums.length) {
                    return -1;
                }
                nums[i+1] ^= 1;
                nums[i+2] ^= 1;
                res++;
            }
        }
        return res;
    }
}

