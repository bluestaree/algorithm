package com.leetcode._2023_11;

import org.junit.Test;


/**
 * 2342. 数位和相等数对的最大和
 *
 * @author DHW
 * @date 2023/11/18 11:40
 * @Version 1.0
 */
public class ProblemsNo2342 {

    @Test
    public void solution() {
        int[] nums = new int[]{18,43,36,13,7};
        System.out.println("minimum = " + maximumSum(nums));
    }

    public int maximumSum(int[] nums) {
        int[] n = new int[100];
        int res = -1;
        for (int num : nums) {
            int x = 0;
            for (int y = num; y > 0; y /= 10) {
                x += y % 10;
            }
            if(n[x] != 0) {
                res = Math.max(res, n[x] + num);
            }
            n[x] = Math.max(n[x], num);
        }
        return res;
    }
}