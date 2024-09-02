package com.leetcode._2024_8;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3153. 所有数对中数位不同之和
 *
 * @author DHW
 * @date 2024/8/30 10:27
 * @Version 1.0
*/
public class ProblemsNo3153 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,6,3,1,4,2,10,9,5};
        System.out.println("res = " + sumDigitDifferences(nums));
    }

    public long sumDigitDifferences(int[] nums) {
        int[][] con = new int[9][10];

        for (int num : nums) {
            int i = 0;
            while(num > 0) {
                con[i++][num % 10]++;
                num /= 10;
            }
        }
        long res = 0;
        int n = nums.length;
        for (int[] counts : con) {
            for (int count : counts) {
                if(count == 0) {
                    continue;
                }
                res += 1l * (n - count) * count;
            }
        }
        return res >> 1;
    }
}

