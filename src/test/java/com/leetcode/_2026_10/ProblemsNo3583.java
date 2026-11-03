package com.leetcode._2026_10;

import org.junit.Test;

import java.util.HashMap;


/**
 * 3583. 统计特殊三元组
 *
 * @author DHW
 * @date 2026/10/23 8:52
 * @Version 1.0
*/
public class ProblemsNo3583 {

    @Test
    public void solution() {
        int[] nums = new int[]{0,1,0,0};
        System.out.println("res = " + specialTriplets(nums));
    }

    public int specialTriplets(int[] nums) {
        long ans = 0;
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.merge(num, 1, Integer::sum);
        }
        HashMap<Integer, Integer> pre = new HashMap<>();
        cnt.merge(nums[0], -1, Integer::sum);
        for (int i = 1; i < nums.length - 1; i++) {
            cnt.merge(nums[i], -1, Integer::sum);
            pre.merge(nums[i-1], 1, Integer::sum);
            int n = nums[i] * 2;
            ans += (long)pre.getOrDefault(n, 0) * cnt.getOrDefault(n, 0);
        }
        return (int)( ans % 1000000007);
    }
}

