package com.leetcode._2026_8;

import org.junit.Test;


/**
 * 2226. 每个小孩最多能分到多少糖果
 *
 * @author DHW
 * @date 2026/8/25 10: 24
 * @Version 1.0
 */
public class ProblemsNo2226 {

    @Test
    public void solution() {
        int[] candies = new int[]{100000};
        long k = 1;
        System.out.println("= res = " + maximumCandies(candies, k));
    }

    public int maximumCandies(int[] candies, long k) {
        int left = 1;
        int right = 0;
        int mx = 0;
        long sum = 0;
        for (int candy : candies) {
            sum += candy;
            mx = Math.max(mx, candy);
        }
        right = (int)Math.min(mx, sum / k) + 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(check(mid, candies, k)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private boolean check(int mid, int[] candies, long k) {
        long count = 0;
        for (int candy : candies) {
            count += candy / mid;
            if (count >= k) {
                return true;
            }
        }
        return false;
    }
}

