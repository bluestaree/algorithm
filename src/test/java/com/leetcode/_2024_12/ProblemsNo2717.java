package com.leetcode._2024_12;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 2717. 半有序排列
 *
 * @author DHW
 * @date 2024/12/11 9: 34
 * @Version 1.0
*/
public class ProblemsNo2717 {

    @Test
    public void solution() {
        int[] nums = new int[]{2,1,4,3};
        System.out.println("res = " + semiOrderedPermutation(nums));
    }

    public int semiOrderedPermutation(int[] nums) {
        int len = nums.length;
        int l = 0;
        int r = len - 1;

        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                l = i;
            } else if (nums[i] == len) {
                r = i;
            }
        }
        return l + len - r - 1 - (l > r ? 1 : 0);
    }
}

