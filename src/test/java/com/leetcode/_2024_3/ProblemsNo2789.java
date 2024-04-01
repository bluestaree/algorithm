package com.leetcode._2024_3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;


/**
 * 2789. 合并后数组中的最大元素
 *
 * @author DHW
 * @date 2024/3/14 9:29
 * @Version 1.0
*/
public class ProblemsNo2789 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,2,6};
        System.out.println("res = " + maxArrayValue(nums));
    }

    public long maxArrayValue(int[] nums) {
        int len = nums.length;
        long res = nums[len-1];
        long t = nums[len-1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] <= t) {
                t += nums[i];
            } else {
                t = nums[i];
            }
            res = Math.max(res, t);
        }
        return res;
    }

}

