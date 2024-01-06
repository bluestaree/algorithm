package com.leetcode._2023_12;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * 1962. 移除石子使总数最小
 *
 * @author DHW
 * @date 2023/12/18 12:23
 * @Version 1.0
*/
public class ProblemsNo1962 {

    @Test
    public void solution() {
        int[] nums = new int[]{5,4,9};
        int k = 2;
        System.out.println("res = " + minStoneSum(nums, k));
    }

    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        int sum = Arrays.stream(piles).sum();
        Arrays.stream(piles).forEach(c->queue.add(c));
        for (int i = 0; i < k; i++) {
            Integer a = queue.poll();
            Integer b = a >> 1;
            sum -= b;
            queue.add(a-b);
        }
        return sum;
    }
}

