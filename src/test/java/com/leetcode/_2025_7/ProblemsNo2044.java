package com.leetcode._2025_7;

import org.junit.Test;

import java.util.HashSet;


/**
 * 2044. 统计按位或能得到最大值的子集数目
 *
 * @author DHW
 * @date 2025/7/28 9: 22
 * @Version 1.0
 */
public class ProblemsNo2044 {

    @Test
    public void solution() {
        int[] nums = new int[]{2, 5};
        System.out.println("res = " + countMaxOrSubsets(nums));
    }

    int maxOr = 0;
    int ans = 0;
    int n = 0;
    int[] nums;

    public int countMaxOrSubsets(int[] nums) {
        n = nums.length;
        this.nums = nums;
        for (int num : nums) {
            maxOr |= num;
        }
        dfs(0, 0);
        return ans;
    }

    private void dfs(int i, int t) {
        if (i == n) {
            if (t == maxOr) {
                ans++;
            }
            return;
        }
        dfs(i + 1, t | nums[i]);
        dfs(i + 1, t);
    }

}

