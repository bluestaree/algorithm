package com.leetcode._2023_6;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;


/**
 * 2460. 对数组执行操作
 *
 * @author DHW
 * @date 2023/6/5 8:53
 * @Version 1.0
*/
public class ProblemsNo2460 {

    @Test
    public void solution() {
        int[] nums = new int[]{0,1};

        System.out.println("res = " + applyOperations(nums));
    }

    public int[] applyOperations(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        int j = 0;
        for (int i = 0 ; i < length - 1; i++,j++) {
            if(nums[i] == 0) {
                j--;
                continue;
            }
            if(nums[i] == nums[i+1]) {
                nums[i+1] = 0;
                res[j] = nums[i] * 2;
            } else {
                res[j] = nums[i];
            }
        }
        if(nums[length-1] != 0) {
            res[j] = nums[length-1];
        }
        return res;
    }
}
