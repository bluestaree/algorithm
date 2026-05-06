package com.leetcode._2026_4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


/**
 * 2367. 等差三元组的数目
 *
 * @author DHW
 * @date 2026/4/27 10: 14
 * @Version 1.0
 */
public class ProblemsNo2367 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,3,1,4,1,3,2};
        int diff = 2;
        System.out.println("sortArrayByParity(nums) = " + arithmeticTriplets(nums, diff));
    }

    public int arithmeticTriplets(int[] nums, int diff) {
        int ans = 0, i = 0, j = 1;
        for (int num : nums) {
            while (nums[j] + diff < num) {
                j++;
            }
            if(nums[j] + diff > num) {
                continue;
            }
            while (nums[i] + diff * 2 < num) {
                i++;
            }
            if(nums[i] + diff * 2 == num) {
                ans++;
            }
        }
        return ans;
    }
}

