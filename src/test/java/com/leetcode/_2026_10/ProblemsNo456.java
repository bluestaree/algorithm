package com.leetcode._2026_10;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


/**
 * 456. 132 模式
 *
 * @author DHW
 * @date 2026/10/29 8:52
 * @Version 1.0
*/
public class ProblemsNo456 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,2,8,3};
        System.out.println("res = " + find132pattern(nums));
    }

    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Deque<Integer> d = new ArrayDeque<>();
        int k = Integer.MIN_VALUE;
        for(int i = n - 1; i >= 0; i--) {
            if(nums[i] < k) {
                return true;
            }
            while (!d.isEmpty() && d.peekLast() < nums[i]) {
                k = Math.max(k, d.pollLast());
            }
            d.addLast(nums[i]);
        }
        return false;
    }
}

