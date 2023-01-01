package com.leetcode._2022_12;

import org.junit.Test;


/**
 * 1827. 最少操作使数组递增
 *
 * @author DHW
 * @date 2022/12/11 11:38
 * @Version 1.0
*/
public class ProblemsNo1827 {

    @Test
    public void solution() {
        int[] num = new int[]{1,1,1};
        System.out.println("res = " + minOperations(num));
    }

    public int minOperations(int[] nums) {
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if(num > nums[i-1]) {
                continue;
            }
            int abs = Math.abs(num - nums[i - 1]) + 1;
            nums[i] = nums[i] + abs ;
            res += abs;
        }
        return res;
    }
}
