package com.leetcode._2024_7;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;


/**
 * 3115. 质数的最大距离
 *
 * @author DHW
 * @date 2024/7/2 9:34
 * @Version 1.0
*/
public class ProblemsNo3115 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,8,2,8};
        System.out.println("res = " + maximumPrimeDifference(nums));
    }

    public int maximumPrimeDifference(int[] nums) {
        int a = 0;
        int b = nums.length - 1;
        for (int i = 0; i <= b; i++) {
            if(checkNum(nums[i])) {
                a = i;
                break;
            }
        }
        for (int i = b; i >= 0; i--) {
            if(checkNum(nums[i])) {
                b = i;
                break;
            }
        }
        return b - a;
    }

    private boolean checkNum(int num) {
        if(num == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

