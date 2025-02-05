package com.leetcode._2025_1;

import org.junit.Test;


/**
 * 2239. 找到最接近 0 的数字
 *
 * @author DHW
 * @date 2022/1/20 8: 47
 * @Version 1.0
*/
public class ProblemsNo2239 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,6};
        System.out.println("res = " + findClosestNumber(nums));
    }

    public int findClosestNumber(int[] nums) {
        int ans = nums[0];
        for (int x : nums) {
            if (Math.abs(x) < Math.abs(ans) || Math.abs(x) == Math.abs(ans) && x > 0) {
                ans = x;
            }
        }
        return ans;
    }
}

