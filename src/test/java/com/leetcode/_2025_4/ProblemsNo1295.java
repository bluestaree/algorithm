package com.leetcode._2025_4;

import org.junit.Test;


/**
 * 1295. 统计位数为偶数的数字
 *
 * @author DHW
 * @date 2025/4/30 8: 37
 * @Version 1.0
 */
public class ProblemsNo1295 {

    @Test
    public void solution() {
        int[] nums = new int[]{2,1,4,3,5};
        System.out.println("res = " + findNumbers(nums));
    }

    public int findNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            while(num >= 100) {
                num /= 100;
            }
            if(num >= 10) {
                res++;
            }
        }
        return res;
    }
}

