package com.leetcode._2024_7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 3011. 判断一个数组是否可以变为有序
 *
 * @author DHW
 * @date 2024/7/13 11:24
 * @Version 1.0
*/
public class ProblemsNo3011 {

    @Test
    public void solution() {
        int[] nums = new int[]{8,4,2,30,15};
        System.out.println("res = " + canSortArray(nums));

    }


    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n;) {
            int start = i;
            int count = Integer.bitCount(nums[i++]);
            while(i < n && count == Integer.bitCount(nums[i])) {
                i++;
            }
            Arrays.sort(nums, start, i);
        }
        for (int i = 1; i < n; i++) {
            if(nums[i] < nums[i-1]) {
                return false;
            }
        }
        return true;
    }
}

