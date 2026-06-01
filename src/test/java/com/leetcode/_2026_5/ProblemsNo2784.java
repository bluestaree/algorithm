package com.leetcode._2026_5;

import org.junit.Test;
import org.junit.runner.Request;


/**
 * 2784. 检查数组是否是好的
 *
 * @author DHW
 * @date 2026/5/14 8: 52
 * @Version 1.0
 */
public class ProblemsNo2784 {

    @Test
    public void solution() {
        int[] nums1 = new int[]{1,3,5,4,7};
        isGood(nums1);
    }

    public boolean isGood(int[] nums) {
        int n = nums.length - 1;

        int[] cnt = new int[n + 1];
        for (int num : nums) {
            if(num > n ||
            num == n && cnt[num] > 1||
            num < n && cnt[num] > 0) {
                return false;
            }
            cnt[num]++;
        }
        return true;
    }

}

