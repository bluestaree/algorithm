package com.leetcode._2023_7;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2208. 将数组和减半的最少操作次数
 *
 * @author DHW
 * @date 2023/7/25 8:48
 * @Version 1.0
*/
public class ProblemsNo2208 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,1,4,1,4,1};
        System.out.println("res = " + halveArray(nums));
    }

    public int halveArray(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int res = 0;
        double target = 0;
        double[] copys = new double[length];
        for (int i = 0; i < nums.length; i++) {
            copys[i] = nums[i];
            target += nums[i];
        }
        target /= 2;
        double sum = 0;
        double num;
        for (int i = length - 1; i >= 0; i--) {
            if(copys[i] < copys[length - 1]) {
                Arrays.sort(copys);
                i = length - 1;
            }
            num = copys[i];
            while(i == 0 || (num >= copys[i-1] && num >= copys[length - 1])) {
                res++;
                num /= 2;
                sum += num;
                if(sum >= target) {
                    return res;
                }
            }
            copys[i] = num;
        }
        return res;
    }

}
