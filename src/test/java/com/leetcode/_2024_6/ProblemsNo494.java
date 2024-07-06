package com.leetcode._2024_6;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


/**
 * 494. 目标和
 *
 * @author DHW
 * @date 2024/6/30 11:00
 * @Version 1.0
*/
public class ProblemsNo494 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,1,2,2,3,3};
        int target = 0;
        System.out.println("res = " + findTargetSumWays(nums, target));
    }

    int count;

    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, 0, 0, target);
        return count;
    }

    private void dfs(int[] nums, int i, int num, int target) {
        if(i == nums.length) {
            if(target == num) {
                count++;
            }
        } else {
            dfs(nums, i+1, num + nums[i], target);
            dfs(nums, i+1, num - nums[i], target);
        }
    }
}

