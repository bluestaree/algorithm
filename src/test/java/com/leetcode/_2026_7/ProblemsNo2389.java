package com.leetcode._2026_7;

import org.junit.Test;

import java.awt.geom.QuadCurve2D;
import java.util.Arrays;


/**
 * 2389. 和有限的最长子序列
 *
 * @author DHW
 * @date 2026/7/23 9: 18
 * @Version 1.0
 */
public class ProblemsNo2389 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,5,2,1};
        int[] queries = new int[]{3,10,21};
        System.out.println("= res = " + answerQueries(nums, queries));
    }

    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        int n = queries.length;
        int m = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int q = queries[i];
            int l = 0;
            int r = m - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] <= q) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            ans[i] = l;
        }
        return ans;
    }
}

