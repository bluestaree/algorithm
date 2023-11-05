package com.leetcode._2023_10;

import org.junit.Test;

import java.util.HashSet;


/**
 * 136. 只出现一次的数字
 *
 * @author DHW
 * @date 2023/10/14 10:51
 * @Version 1.0
*/
public class ProblemsNo136 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,2,2,1,5};
        System.out.println("res = " + singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int v : nums) {
            ans ^= v;
        }
        return ans;
    }
}

