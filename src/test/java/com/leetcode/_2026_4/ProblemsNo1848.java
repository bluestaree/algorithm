package com.leetcode._2026_4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * 1848. 到目标元素的最小距离
 *
 * @author DHW
 * @date 2026/4/13 8: 42
 * @Version 1.0
 */
public class ProblemsNo1848 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        int target = 2;
        int start = 2;
        System.out.println("sortArrayByParity(nums) = " + getMinDistance(nums, target, start));
    }

    public int getMinDistance(int[] nums, int target, int start) {
        int l = start;
        int r = start;
        while (true) {
            if (l >= 0 && nums[l] == target) {
                return start - l;
            }
            if (r < nums.length && nums[r] == target) {
                return r - start;
            }
            l--;
            r++;
        }
    }
}

