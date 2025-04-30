package com.leetcode._2025_4;

import org.junit.Test;


/**
 * 2873. 有序三元组中的最大值 I
 *
 * @author DHW
 * @date 2025/4/2 9: 09
 * @Version 1.0
*/
public class ProblemsNo2873 {

    @Test
    public void solution() {
        int[] nums = new int[]{2,3,12,0,4,6,7};
        System.out.println("res = " + maximumTripletValue(nums));
    }

    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long res = 0;
        long mxdif = 0;
        int mx = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, mxdif * nums[i]);
            mxdif = Math.max(mxdif, mx - nums[i]);
            mx = Math.max(mx, nums[i]);
        }
        return res;
    }
}

