package com.leetcode._2024_6;

import org.junit.Test;


/**
 * 3038. 相同分数的最大操作数目 I
 *
 * @author DHW
 * @date 2024/6/7 9:08
 * @Version 1.0
*/
public class ProblemsNo3038 {

    @Test
    public void solution() {
        int[] nums = new int[]{3,5,2,6};
        System.out.println("res = " + maxOperations(nums));
    }

    public int maxOperations(int[] nums) {
        int num = nums[1] + nums[0];
        int res = 1;
        for (int i = 3; i < nums.length && nums[i-1] + nums[i] == num; i+=2) {
            res++;
        }
        return res;
    }
}

