package com.leetcode._2026_8;

import org.junit.Test;


/**
 * 875. 爱吃香蕉的珂珂
 *
 * @author DHW
 * @date 2026/8/11 8: 37
 * @Version 1.0
 */
public class ProblemsNo875 {

    @Test
    public void solution() {
        int[] piles = new int[]{805306368,805306368,805306368};
        int h = 1000000000;
        System.out.println("= res = " + minEatingSpeed(piles, h));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(checkRes(mid, piles, h)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean checkRes(int x, int[] piles, int h) {
        int sum = piles.length;
        for(int pile : piles) {
            sum += (pile - 1) / x;
            if(sum > h) {
                return false;
            }
        }
        return true;
    }
}

