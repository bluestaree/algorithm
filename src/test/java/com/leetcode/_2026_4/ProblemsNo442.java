package com.leetcode._2026_4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


/**
 * 442. 数组中重复的数据
 *
 * @author DHW
 * @date 2026/4/1 10: 24
 * @Version 1.0
 */
public class ProblemsNo442 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        System.out.println("sortArrayByParity(nums) = " + findDuplicates(nums));
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int numIndex = Math.abs(nums[i]) - 1;
            if(nums[numIndex] > 0) {
                nums[numIndex] *= -1;
            } else {
                list.add(numIndex + 1);
            }
        }
        return list;
    }

}

