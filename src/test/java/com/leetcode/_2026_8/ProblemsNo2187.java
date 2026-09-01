package com.leetcode._2026_8;

import org.junit.Test;


/**
 * 2187. 完成旅途的最少时间
 *
 * @author DHW
 * @date 2026/8/6 8: 55
 * @Version 1.0
 */
public class ProblemsNo2187 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,5,2,1};
        int totalTrips = 6;
        System.out.println("= res = " + minimumTime(nums, totalTrips));
    }
    public long minimumTime(int[] time, int totalTrips) {
        long left = Integer.MAX_VALUE;
        for (int i : time) {
            left = Math.min(left, i);
        }
        long right = left * totalTrips;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if(checkTime(mid, time, totalTrips)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean checkTime(long mid, int[] time, int totalTrips) {
        long sum = 0;
        for (int i : time) {
            sum += mid / i;
            if(sum >= totalTrips) {
                return true;
            }
        }
        return false;
    }
}

