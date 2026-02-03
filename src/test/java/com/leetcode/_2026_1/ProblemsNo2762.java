package com.leetcode._2026_1;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * 2762. 不间断子数组
 *
 * @author DHW
 * @date 2026/1/16 10: 29
 * @Version 1.0
*/
public class ProblemsNo2762 {

    @Test
    public void solution() {
        int[] nums = new int[]{5,4,2,4};
        System.out.println("res = " + continuousSubarrays(nums));
    }

    public long continuousSubarrays(int[] nums) {

        ArrayDeque<Integer> minDeque = new ArrayDeque<>();
        ArrayDeque<Integer> maxDeque = new ArrayDeque<>();

        long ans = 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            int x = nums[r];
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= x) {
                minDeque.pollLast();
            }
            minDeque.offerLast(r);

            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= x) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(r);

            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > 2) {
                l++;
                if(minDeque.peekFirst() < l) {
                    minDeque.pollFirst();
                }
                if(maxDeque.peekFirst() < l) {
                    maxDeque.pollFirst();
                }
            }
            ans += r - l + 1;
        }
        return ans;
    }

}

