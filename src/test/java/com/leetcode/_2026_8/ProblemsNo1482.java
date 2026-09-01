package com.leetcode._2026_8;

import org.junit.Test;


/**
 * 1482. 制作 m 束花所需的最少天数
 *
 * @author DHW
 * @date 2026/8/19 9: 44
 * @Version 1.0
 */
public class ProblemsNo1482 {

    @Test
    public void solution() {
        int[] bloomDay = new int[]{4,2,3,1};
        int m = 10;
        int k = 20;
        System.out.println("= res = " + minDays(bloomDay, m, k));
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if(m > bloomDay.length / k) {
            return -1;
        }
        int l = 0;
        int r = 0;
        for (int i : bloomDay) {
            r = Math.max(r, i);
        }

        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(check(mid, bloomDay, m, k)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int mid, int[] bloomDay, int m, int k) {
        int count = 0;
        int flowers = 0;
        for (int i : bloomDay) {
            if(i <= mid) {
                flowers++;
                if(flowers == k) {
                    count++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return count >= m;
    }
}

