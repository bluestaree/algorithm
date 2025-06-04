package com.leetcode._2025_5;

import org.junit.Test;


/**
 * 3356. 零数组变换 II
 *
 * @author DHW
 * @date 2025/5/21 9: 14
 * @Version 1.0
 */
public class ProblemsNo3356 {

    @Test
    public void solution() {
        int[] nums = new int[]{0, 2, 1, 5, 3, 4};
        int[][] queries = new int[][]{new int[]{1, 2}, new int[]{5, 6}, new int[]{9, 10}};
        System.out.println("res = " + minZeroArray(nums, queries));
    }

    int n;
    int m;
    int[][] queries;
    int[] nums;

    public int minZeroArray(int[] nums, int[][] queries) {
        this.queries = queries;
        this.nums = nums;
        n = nums.length;
        m = queries.length;
        int l = 0;
        int r = m + 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l > m ? -1 : l;

    }

    public boolean check(int k) {
        int[] d = new int[n + 1];
        for (int i = 0; i < k; i++) {
            d[queries[i][0]] += queries[i][2];
            d[queries[i][1] + 1] -= queries[i][2];
        }

        int s = 0;
        for (int i = 0; i < n; i++) {
            s += d[i];
            if (nums[i] > s) {
                return false;
            }
        }
        return true;
    }
}

