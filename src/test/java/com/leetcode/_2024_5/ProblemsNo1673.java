package com.leetcode._2024_5;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * 1673. 找出最具竞争力的子序列
 *
 * @author DHW
 * @date 2024/5/24 8:39
 * @Version 1.0
*/
public class ProblemsNo1673 {

    @Test
    public void solution() {
        int[] nums = new int[]{3,5,2,6};
        int k = 2;
        System.out.println("res = " + mostCompetitive(nums, k));
    }

    public int[] mostCompetitive(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        if(n == k) {
            return nums;
        }
        for (int i = 0; i < n; i++) {

            while(!deque.isEmpty() && deque.peek() > nums[i] && deque.size() + n - i > k) {
                deque.poll();
            }
            if(deque.size() < k) {
                deque.push(nums[i]);
            }
        }
        int[] res = new int[k];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = deque.poll();
        }
        return res;
    }
}

