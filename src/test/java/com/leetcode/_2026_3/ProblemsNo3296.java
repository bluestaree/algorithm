package com.leetcode._2026_3;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;


/**
 * 3296. 移山所需的最少秒数
 *
 * @author DHW
 * @date 2026/3/13 9: 36
 * @Version 1.0
*/
public class ProblemsNo3296 {

    @Test
    public void solution() {
        int[] workerTimes = new int[]{2,2,3,3};
        int mountainHeight = 5;
        System.out.println("res = " + minNumberOfSeconds(mountainHeight, workerTimes));
    }

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long ans = 0;
        int n = workerTimes.length;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> Long.compare(a[0] + a[1], b[0] + b[1]));
        for (int i = 0; i < n; i++) {
            pq.offer(new long[]{0, workerTimes[i], workerTimes[i]});
        }
        for (int i = 0; i < mountainHeight; i++) {
            long[] poll = pq.poll();
            long total = poll[0];
            long next = poll[1];
            long original = poll[2];
            pq.offer(new long[]{total + next, next + original, original});
            ans = total + next;
        }
        return ans;
    }
}

