package com.leetcode._2024_9;

import org.junit.Test;

import java.util.PriorityQueue;


/**
 * 1845. 座位预约管理系统
 *
 * @author DHW
 * @date 2024/9/30 9:35
 * @Version 1.0
 */
public class ProblemsNo1845 {

    @Test
    public void solution() {
        SeatManager obj = new SeatManager(n);
        int param_1 = obj.reserve();
        obj.unreserve(3);
    }

    class SeatManager {

        PriorityQueue<Integer> queue = new PriorityQueue();

        public SeatManager(int n) {
            for (int i = 1; i <= n; i++) {
                queue.offer(i);
            }
        }

        public int reserve() {
            return queue.poll();
        }

        public void unreserve(int seatNumber) {
            queue.offer(seatNumber);
        }
    }
}

