package com.leetcode._2026_8;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;


/**
 * 2594. 修车的最少时间
 *
 * @author DHW
 * @date 2026/8/18 8: 55
 * @Version 1.0
 */
public class ProblemsNo2594 {

    @Test
    public void solution() {
        int[] ranks = new int[]{4,2,3,1};
        int cars = 10;
        System.out.println("= res = " + repairCars(ranks, cars));
    }

    public long repairCars(int[] ranks, int cars) {
        long l = 1;
        long r = Integer.MAX_VALUE;
        for (int rank : ranks) {
            r = Math.min(r, rank);
        }
        r = r * cars * cars;
        while(l <= r) {
            long mid = l + (r - l) / 2;
            if(check(mid, ranks, cars)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(long mid, int[] ranks, int cars) {
        int sum = 0;
        for (int rank : ranks) {
            sum += Math.sqrt(mid / rank);
        }
        if(sum >= cars) {
            return true;
        }
        return false;
    }
}

