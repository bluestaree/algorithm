package com.leetcode._2024_5;

import org.junit.Test;

import java.util.Arrays;


/**
 * 1953. 你可以工作的最大周数
 *
 * @author DHW
 * @date 2024/5/16 8:39
 * @Version 1.0
*/
public class ProblemsNo1953 {

    @Test
    public void solution() {
        int[] milestones = new int[]{1,1,1,4,2,3};
        System.out.println("res = " + numberOfWeeks(milestones));
    }

    public long numberOfWeeks(int[] milestones) {
        Arrays.sort(milestones);
        int n = milestones.length;
        int max = milestones[n - 1];
        long restSum = 0;
        for (int i = 0; i < n - 1; i++) {
            restSum += milestones[i];
        }
        if (restSum >= max) return restSum + max;
        return restSum * 2 + 1;
    }
}

