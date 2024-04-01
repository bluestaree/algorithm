package com.leetcode._2024_2;

import org.junit.Test;

import java.util.PriorityQueue;


/**
 * LCP 30. 魔塔游戏
 *
 * @author DHW
 * @date 2024/2/6 9:15
 * @Version 1.0
*/
public class ProblemsNoLCP30 {

    @Test
    public void solution() {
        int[] nums = new int[]{100,100,100,-250,-60,-140,-50,-50,100,150};
        System.out.println("res = " + magicTower(nums));
    }

    public int magicTower(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        long total = 0;
        long count = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            if(nums[i] < 0) {
                queue.add(nums[i]);
            }
            if(total < 0 && !queue.isEmpty()) {
                Integer num = Math.abs(queue.poll());
                count += num;
                total += num;
                res++;
            }
        }
        if(total < count) {
            return -1;
        }
        return res;
    }
}

