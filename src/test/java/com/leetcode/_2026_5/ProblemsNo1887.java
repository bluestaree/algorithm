package com.leetcode._2026_5;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * 1887. 使数组元素相等的减少操作次数
 *
 * @author DHW
 * @date 2026/5/21 9: 41
 * @Version 1.0
 */
public class ProblemsNo1887 {

    @Test
    public void solution() {
        int[] nums = new int[]{5,1,3};
        System.out.println("res = " + reductionOperations(nums));
    }

    public int reductionOperations(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        int num = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]) {
                num++;
            }
            ans += num;
        }
        return ans;
    }

}

