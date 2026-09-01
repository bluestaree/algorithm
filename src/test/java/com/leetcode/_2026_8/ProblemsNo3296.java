package com.leetcode._2026_8;

import org.junit.Test;

import java.util.PriorityQueue;


/**
 * 3296. 移山所需的最少秒数
 *
 * @author DHW
 * @date 2026/8/13 8: 45
 * @Version 1.0
 */
public class ProblemsNo3296 {

    @Test
    public void solution() {
        int[] workerTimes = new int[]{5};
        int mountainHeight = 1;
        System.out.println("= res = " + minNumberOfSeconds(mountainHeight, workerTimes));
    }

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int maxT = 0;
        for (int t : workerTimes) {
            maxT = Math.max(maxT, t);
        }
        int h = (mountainHeight - 1) / workerTimes.length + 1;
        long left = 0;
        long right = (long) maxT * h * (h + 1) / 2;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (check(mid, mountainHeight, workerTimes)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean check(long m, int leftH, int[] workerTimes) {
        for (int t : workerTimes) {
            leftH -= ((int) Math.sqrt(m / t * 8 + 1) - 1) / 2;
            if (leftH <= 0) {
                return false;
            }
        }
        return true;
    }
}

