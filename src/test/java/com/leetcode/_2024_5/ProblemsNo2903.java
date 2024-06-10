package com.leetcode._2024_5;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * 2903. 找出满足差值条件的下标 I
 *
 * @author DHW
 * @date 2024/5/25 11:33
 * @Version 1.0
*/
public class ProblemsNo2903 {

    @Test
    public void solution() {
        int valueDifference = 3;
        int indexDifference = 4;
        int[] nums = new int[]{5,1,4,1};
        System.out.println("res = " + findIndices(nums, indexDifference, valueDifference));
    }

    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + indexDifference; j < nums.length; j++) {
                if(Math.abs(nums[i] - nums[j]) >= valueDifference) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1,-1};
    }
}

