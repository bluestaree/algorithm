package com.leetcode._2025_6;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2294. 划分数组使最大差为 K
 *
 * @author DHW
 * @date 2025/6/19 8: 40
 * @Version 1.0
*/
public class ProblemsNo2294 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,3,4,8,7,9,3,5,1};
        int k = 2;
        System.out.println("res = " + partitionArray(nums, k));
    }

    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int pre = 0;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] - nums[pre] > k) {
                pre = i;
                res++;
            }
        }
        return res;
    }
}

