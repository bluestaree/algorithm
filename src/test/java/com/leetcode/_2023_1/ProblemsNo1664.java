package com.leetcode._2023_1;

import org.junit.Test;

import java.util.Arrays;


/**
 * 1664. 生成平衡数组的方案数
 *
 * @author DHW
 * @date 2023/1/28 9:53
 * @Version 1.0
*/
public class ProblemsNo1664 {

    @Test
    public void solution() {
        int[] nums = new int[]{2,1,6,4};
        System.out.println("res = " + waysToMakeFair(nums));
    }

    public int waysToMakeFair(int[] nums) {
        int s1 = 0 ,s2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i % 2 == 0) {
                s2 += nums[i];
            } else {
                s1 += nums[i];
            }
        }

        int t1 = 0 ,t2 = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(i % 2 == 0) {
                if((t2 + (s1 - t1)) == (t1 + (s2 - t2 - num))) {
                    res++;
                }
                t2 += num;
            } else {
                if((t2 + (s1 - t1 - num)) == (t1 + (s2 - t2))) {
                    res++;
                }
                t1 += num;
            }
        }

        return res;
    }
}
