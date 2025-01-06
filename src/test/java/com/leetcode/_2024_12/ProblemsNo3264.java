package com.leetcode._2024_12;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


/**
 * 3264. K 次乘运算后的最终数组 I
 *
 * @author DHW
 * @date 2024/12/13 8: 33
 * @Version 1.0
*/
public class ProblemsNo3264 {

    @Test
    public void solution() {
        int[] nums = new int[]{2,1,3,5,6};
        int k = 5;
        int multiplier = 2;
        System.out.println("res = " + getFinalState(nums, k, multiplier));
    }

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        for (int i = 0; i < nums.length; i++) {
            queue.add(new int[]{i, nums[i]});
        }
        while (k > 0) {
            int[] a = queue.poll();
            nums[a[0]] *= multiplier;
            queue.add(new int[]{a[0], nums[a[0]]});
            k--;
        }
        return nums;
    }
}

