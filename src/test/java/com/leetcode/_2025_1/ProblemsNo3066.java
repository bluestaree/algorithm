package com.leetcode._2025_1;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * 3066. 超过阈值的最少操作数 II
 *
 * @author DHW
 * @date 2022/1/15 8: 34
 * @Version 1.0
*/
public class ProblemsNo3066 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,6};
        int k = 2;
        System.out.println("res = " + minOperations(nums,k));
    }

    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add((long) num);
        }
        int res = 0;
        while(queue.peek() < k) {
            res++;
            Long l1 = queue.poll();
            Long l2 = queue.poll();
            queue.add(l1 * 2 + l2);
        }
        return res;
    }
}

