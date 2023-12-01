package com.leetcode._2023_11;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2216. 美化数组的最少删除数
 *
 * @author DHW
 * @date 2023/11/21 19:01
 * @Version 1.0
*/
public class ProblemsNo2216 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,1,2,3,5};
        System.out.println("res = " + minDeletion(nums));
    }

    public int minDeletion(int[] nums) {
        int res = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if((i - res) % 2 == 0 && i < length - 1 && nums[i] == nums[i + 1]) {
                res++;
            }
        }
        return (length-res) % 2 == 0 ? res : res+1;
    }

}

