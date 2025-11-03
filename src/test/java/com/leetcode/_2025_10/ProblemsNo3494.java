package com.leetcode._2025_10;

import org.junit.Test;
import org.springframework.format.FormatterRegistrar;

import java.util.Arrays;


/**
 * 3494. 酿造药水需要的最少总时间
 *
 * @author DHW
 * @date 2025/10/9 9: 35
 * @Version 1.0
*/
public class ProblemsNo3494 {

    @Test
    public void solution() {
        int[] skill =  new int[]{1,5,2,4};
        int[] mana =  new int[]{5,1,4,2};
        System.out.println("res = " + minTime(skill, mana));
    }

    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        long[] f = new long[n];
        for (int x : mana) {
            long num = 0;
            for (int i = 0; i < skill.length; i++) {
                num = Math.max(num, f[i]) + x * skill[i];
            }
            f[n-1] = num;
            for (int i = n - 2; i >= 0; i--) {
                f[i] = f[i+1] - x * skill[i+1];
            }
        }
        return f[n-1];
    }

}

