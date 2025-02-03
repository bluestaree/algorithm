package com.leetcode._2025_1;

import org.junit.Test;

import java.util.Arrays;


/**
 * 45. 跳跃游戏 II
 *
 * @author DHW
 * @date 2025/1/27 10: 31
 * @Version 1.0
*/
public class ProblemsNo45 {

    @Test
    public void solution() {
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println("res = " + jump(nums));
    }

    public int jump(int[] nums) {
        int maxJump = 0;
        int preJumpMaxIndex = 0;
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxJump = Math.max(maxJump, i + nums[i]);
            if(preJumpMaxIndex == i) {
                res++;
                preJumpMaxIndex = maxJump;
            }
        }
        return res;
    }
}

