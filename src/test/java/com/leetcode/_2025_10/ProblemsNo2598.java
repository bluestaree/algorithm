package com.leetcode._2025_10;

import org.junit.Test;


/**
 * 2598. 执行操作后的最大 MEX
 *
 * @author DHW
 * @date 2025/10/16 8: 56
 * @Version 1.0
*/
public class ProblemsNo2598 {

    @Test
    public void solution() {
        int[] nums =  new int[]{1,-10,7,13,6,8};
        int value = 7;
        System.out.println("res = " + findSmallestInteger(nums, value));
    }

    public int findSmallestInteger(int[] nums, int value) {
        int[] cnt = new int[value];
        for (int num : nums) {
            cnt[(num % value + value) % value]++;
        }
        for (int i = 0; ; ++i) {
            if (cnt[i % value]-- == 0) {
                return i;
            }
        }
    }

}

