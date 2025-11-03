package com.leetcode._2025_10;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;


/**
 * 3350. 检测相邻递增子数组 II
 *
 * @author DHW
 * @date 2025/10/15 8: 50
 * @Version 1.0
*/
public class ProblemsNo3350 {

    @Test
    public void solution() {
        Integer[] arr = new Integer[]{2,5,7,8,9,2,3,4,3,1};
        List<Integer> list = Arrays.asList(arr);
        System.out.println("res = " + maxIncreasingSubarrays(list));
    }

    public int maxIncreasingSubarrays(List<Integer> nums) {
        int mx = 0, pre = 0, cur = 0;
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            cur++;
            if(i == n - 1 || nums.get(i) >= nums.get(i + 1)) {
                mx = Math.max(mx, Math.max(cur / 2, Math.min(pre, cur)));
                pre = cur;
                cur = 0;
            }
        }
        return mx;
    }
}

