package com.leetcode._2024_1;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * 1944. 队列中可以看到的人数
 *
 * @author DHW
 * @date 2024/1/5 9:16
 * @Version 1.0
*/
public class ProblemsNo1944 {

    @Test
    public void solution() {
        int[] heights = new int[]{10,6,8,5,11,9};
        System.out.println("res = " + canSeePersonsCount(heights));
    }

    public int[] canSeePersonsCount(int[] heights) {
        int len = heights.length;
        int[] res = new int[len];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = len - 1; i >= 0; i--) {
            while(!deque.isEmpty() && deque.peek() < heights[i]) {
                deque.pop();
                res[i]++;
            }
            if(!deque.isEmpty()) {
                res[i]++;
            }
            deque.push(heights[i]);
        }
        return res;
    }
}

