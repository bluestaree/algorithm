package com.leetcode._2025_4;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


/**
 * 3392. 统计符合条件长度为 3 的子数组数目
 *
 * @author DHW
 * @date 2025/4/27 8: 32
 * @Version 1.0
*/
public class ProblemsNo3392 {

    @Test
    public void solution() {
        int[] nums = new int[]{2,3,12,0,4,6,7};
        System.out.println("res = " + countSubarrays(nums));
    }

    public int countSubarrays(int[] nums) {
        int res = 0;
        for(int i = 1; i < nums.length - 1; i++) {
            int left = i - 1, right = i + 1;
            if((nums[left] + nums[right]) * 2 == nums[i]) {
                res++;
            }
        }
        return res;
    }
}

