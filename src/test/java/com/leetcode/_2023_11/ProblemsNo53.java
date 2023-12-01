package com.leetcode._2023_11;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 53. 最大子数组和
 *
 * @author DHW
 * @date 2023/11/20 9:22
 * @Version 1.0
*/
public class ProblemsNo53 {

    @Test
    public void solution() {
        int[] nums = new int[]{0,1,10};
        System.out.println("res = " + maxSubArray(nums));
    }
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        for (int i = 1, f = nums[0]; i < nums.length; ++i) {
            f = Math.max(f, 0) + nums[i];
            ans = Math.max(ans, f);
        }
        return ans;
    }
}

