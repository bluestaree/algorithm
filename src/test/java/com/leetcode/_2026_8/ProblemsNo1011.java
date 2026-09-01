package com.leetcode._2026_8;

import org.junit.Test;

import java.util.Arrays;


/**
 * 1011. 在 D 天内送达包裹的能力
 *
 * @author DHW
 * @date 2026/8/10 9: 05
 * @Version 1.0
 */
public class ProblemsNo1011 {

    @Test
    public void solution() {
        int[] weights = new int[]{5,5,5,5,5,5,5,5,5,5};
        int days = 8;
        System.out.println("= res = " + shipWithinDays(weights, days));
    }

    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(checkRes(mid, weights, days)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean checkRes(int weight, int[] weights, int days) {
        int sum = 0;
        for(int i = 0; i < weights.length; i++) {
            sum += weights[i];
            if(sum > weight) {
                days--;
                sum = weights[i];
            }
        }
        if(sum > 0) {
            days--;
        }
        if(days < 0) {
            return false;
        }
        return true;
    }
}

