package com.leetcode._2024_9;

import org.junit.Test;


/**
 * 2535. 数组元素和与数字和的绝对差
 *
 * @author DHW
 * @date 2024/9/26 9:11
 * @Version 1.0
 */
public class ProblemsNo2535 {

    @Test
    public void solution() {
        int[] nums = new int[]{4, 8, 2, 8};
        System.out.println("res = " + differenceOfSum(nums));
    }

    public int differenceOfSum(int[] nums) {
        int sum0 = 0, sum1 = 0;
        for (int num : nums) {
            sum0 += num;
            while(num > 0) {
                sum1 += (num % 10);
                num /= 10;
            }
        }
        return sum0 - sum1;
    }
}

