package com.leetcode._2024_5;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2644. 找出可整除性得分最大的整数
 *
 * @author DHW
 * @date 2024/5/18 10:52
 * @Version 1.0
*/
public class ProblemsNo2644 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,7,9,3,9};
        int[] divisors = new int[]{5,2,3};
        System.out.println("res = " + maxDivScore(nums, divisors));
    }

    public int maxDivScore(int[] nums, int[] divisors) {
        int ans = 0;
        int maxCnt = -1;
        for (int d : divisors) {
            int cnt = 0;
            for (int x : nums) {
                if (x % d == 0) {
                    cnt++;
                }
            }
            if (cnt > maxCnt || cnt == maxCnt && d < ans) {
                maxCnt = cnt;
                ans = d;
            }
        }
        return ans;
    }
}

