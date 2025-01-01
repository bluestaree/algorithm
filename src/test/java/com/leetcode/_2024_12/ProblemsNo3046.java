package com.leetcode._2024_12;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3046. 分割数组
 *
 * @author DHW
 * @date 2024/12/28 12: 07
 * @Version 1.0
*/
public class ProblemsNo3046 {

    @Test
    public void solution() {
        int[] nums = new int[]{7,4,1};
        System.out.println("res = " + isPossibleToSplit(nums));
    }

    public boolean isPossibleToSplit(int[] nums) {
        int[] cnt = new int[101];
        for (int x : nums) {
            if (++cnt[x] >= 3) {
                return false;
            }
        }
        return true;
    }
}

