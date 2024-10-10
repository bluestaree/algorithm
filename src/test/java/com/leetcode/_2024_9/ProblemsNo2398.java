package com.leetcode._2024_9;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;


/**
 * 2398. 预算内的最多机器人数目
 *
 * @author DHW
 * @date 2024/9/13 9:16
 * @Version 1.0
*/
public class ProblemsNo2398 {

    @Test
    public void solution() {
        int[] chargeTimes = new int[]{28,68,71,14,64,29,15,40};
        int[] runningCosts = new int[]{28,68,71,14,64,29,15,40};
        int budget = 1;
        System.out.println("res = " + maximumRobots(chargeTimes, runningCosts, budget));
    }

    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int left = 0;
        int res = 0;
        long sum = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int right = 0;right < chargeTimes.length; right++) {
            while(!deque.isEmpty() && chargeTimes[right] >= chargeTimes[deque.peekLast()] ) {
                deque.pollLast();
            }
            deque.addLast(right);
            sum += runningCosts[right];

            while(!deque.isEmpty() && (chargeTimes[deque.peekFirst()] + (right - left + 1) * sum) > budget) {
                deque.remove(left);
                sum -= runningCosts[left++];
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}

