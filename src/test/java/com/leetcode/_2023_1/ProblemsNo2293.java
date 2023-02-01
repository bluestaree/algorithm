package com.leetcode._2023_1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * 2293. 极大极小游戏
 *
 * @author DHW
 * @date 2023/1/15 9:32
 * @Version 1.0
*/
public class ProblemsNo2293 {

    @Test
    public void solution() {
        int[] nums = new int[]{3};

        System.out.println("res = " + minMaxGame(nums));
    }

    public int minMaxGame(int[] nums) {
        int n = nums.length;
        while (true) {
            if(n == 1) {
                break;
            }
            n = n >> 1;
            int[] target = new int[n];
            for (int i = 0; i < n; i++) {
                if(i % 2 == 0) {
                    target[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                } else {
                    target[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                }
            }
            nums = target;
        }
        return nums[0];
    }
}
