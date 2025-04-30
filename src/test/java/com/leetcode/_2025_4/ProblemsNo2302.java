package com.leetcode._2025_4;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


/**
 * 2302. 统计得分小于 K 的子数组数目
 *
 * @author DHW
 * @date 2025/4/28 8: 36
 * @Version 1.0
 */
public class ProblemsNo2302 {

    @Test
    public void solution() {
        int[] nums = new int[]{2,1,4,3,5};
        System.out.println("res = " + countSubarrays(nums, 10));
    }

    public long countSubarrays(int[] nums, long k) {
        long res = 0;
        int n = nums.length;
        long[] s = new long[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + nums[i];
        }
        int l = 0;
        for (int r = 0; r < n; r++) {
            while(l <= r && (s[r + 1] - s[l]) * (r - l + 1) >= k) {
                l++;
            }
            res += r - l + 1;
        }
        return res;
    }
}

