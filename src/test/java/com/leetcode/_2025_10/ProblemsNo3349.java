package com.leetcode._2025_10;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * 3349. 检测相邻递增子数组 I
 *
 * @author DHW
 * @date 2025/10/14 9: 14
 * @Version 1.0
*/
public class ProblemsNo3349 {

    @Test
    public void solution() {
        Integer[] arr = new Integer[]{2,5,7,8,9,2,3,4,3,1};
        List<Integer> list = Arrays.asList(arr);
        int k = 1;
        System.out.println("res = " + hasIncreasingSubarrays(list, k));
    }

    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int mx = 0, pre = 0, cur = 0;
        int n = nums.size();
        for (int i = 0; i < n; ++i) {
            ++cur;
            if (i == n - 1 || nums.get(i) >= nums.get(i + 1)) {
                mx = Math.max(mx, Math.max(cur / 2, Math.min(pre, cur)));
                pre = cur;
                cur = 0;
            }
        }
        return mx >= k;
    }
}

