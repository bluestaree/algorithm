package com.leetcode._2024_7;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * 2974. 最小数字游戏
 *
 * @author DHW
 * @date 2024/7/12 9:35
 * @Version 1.0
*/
public class ProblemsNo2974 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,8,2,8};
        System.out.println("res = " + numberGame(nums));
    }

    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i+=2) {
            int temp = nums[i+1];
            nums[i+1] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }
}

