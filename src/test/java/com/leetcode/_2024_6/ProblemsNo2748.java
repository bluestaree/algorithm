package com.leetcode._2024_6;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2748. 美丽下标对的数目
 *
 * @author DHW
 * @date 2024/6/20 10:39
 * @Version 1.0
*/
public class ProblemsNo2748 {

    @Test
    public void solution() {
        int[] nums = new int[]{4,7};
        System.out.println("res = " + countBeautifulPairs(nums));
    }

    public int countBeautifulPairs(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            while(a >= 10) {
                a /= 10;
            }
            for (int j = i + 1; j < nums.length; j++) {
                int b = nums[j] % 10;
                if(gcd(a, b) == 1) {
                    res++;
                }
            }
        }
        return res;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}

