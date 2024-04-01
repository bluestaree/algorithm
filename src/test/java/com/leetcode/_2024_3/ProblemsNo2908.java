package com.leetcode._2024_3;

import cn.hutool.core.util.StrUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;


/**
 * 2908. 元素和最小的山形三元组 I
 *
 * @author DHW
 * @date 2024/3/29 14:05
 * @Version 1.0
*/
public class ProblemsNo2908 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,2,1};
        System.out.println("res = " + minimumSum(nums));
    }

    public int minimumSum(int[] nums) {
        int len = nums.length;
        int[] suf = new int[len];
        suf[len - 1] = nums[len - 1];
        for (int i = len - 2; i > 1; i--) {
            suf[i] = Math.min(suf[i+1], nums[i]);
        }
        int res = Integer.MAX_VALUE;
        int pre = nums[0];
        for (int i = 1; i < len-1; i++) {
            if(pre < nums[i] && nums[i] > suf[i+1]) {
                res = Math.min(res, pre + nums[i] + suf[i+1]);
            }
            pre = Math.min(pre, nums[i]);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

}

