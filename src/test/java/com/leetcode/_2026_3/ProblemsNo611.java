package com.leetcode._2026_3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 611. 有效三角形的个数
 *
 * @author DHW
 * @date 2026/3/16 10: 12
 * @Version 1.0
*/
public class ProblemsNo611 {

    @Test
    public void solution() {
        int[] nums = new int[]{2,2,3,3};
        System.out.println("res = " + triangleNumber(nums));
    }

    public int triangleNumber(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 2; i < n; i++) {
            int z = nums[i];
            int l = 0, r = i - 1;
            if (nums[i  - 2] + nums[i  - 1] <= z) {
                continue;
            }
            while (l < r) {
                int x = nums[l], y = nums[r];
                if (x + y > z) {
                    ans += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        return ans;

    }
}

