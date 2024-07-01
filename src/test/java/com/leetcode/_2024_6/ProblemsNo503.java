package com.leetcode._2024_6;

import org.junit.Test;

import java.util.*;


/**
 * 503. 下一个更大元素 II
 *
 * @author DHW
 * @date 2024/6/24 9:28
 * @Version 1.0
*/
public class ProblemsNo503 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,2,1};
        System.out.println("res = " + nextGreaterElements(nums));
    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];
            while(!deque.isEmpty() && nums[deque.peek()] < num) {
                res[deque.pop()] = num;
            }
            if(i < n) {
                deque.push(i);
            }
        }
        return res;
    }

    public int[] nextGreaterElements1(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) {
            int j = (i+1) % n;
            while(j != i) {
                if(nums[i] < nums[j]) {
                   res[i] = nums[j];
                   break;
                }
                j = (j+1) % n;
            }
        }
        return res;
    }
}

