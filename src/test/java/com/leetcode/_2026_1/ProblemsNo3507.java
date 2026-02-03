package com.leetcode._2026_1;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;


/**
 * 3507. 移除最小数对使数组有序 I
 *
 * @author DHW
 * @date 2026/1/22 9: 05
 * @Version 1.0
*/
public class ProblemsNo3507 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,2,2};
        System.out.println("res = " + minimumPairRemoval(nums));
    }

    public int minimumPairRemoval(int[] nums) {
        int ans = 0;
        int[] curNums = nums;
        while (!isSorted(curNums)){
            int minSum = Integer.MAX_VALUE;
            int s = 0;
            int index = 0;
            int n = curNums.length;
            for (int i = 1; i < n; i++) {
                s = curNums[i] + curNums[i - 1];
                if (s < minSum) {
                    minSum = s;
                    index = i;
                }
            }
            int[] temp = new int[n - 1];
            for (int i = 0; i < index - 1; i++) {
                temp[i] = curNums[i];
            }
            temp[index - 1] = minSum;
            for (int i = index + 1; i < n; i++) {
                temp[i - 1] = curNums[i];
            }
            ans++;
            curNums = temp;
        }
        return ans;
    }

    public boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }

}

