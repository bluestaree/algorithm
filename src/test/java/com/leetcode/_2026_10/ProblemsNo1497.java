package com.leetcode._2026_10;

import org.junit.Test;

import java.util.Arrays;


/**
 * 1497. 检查数组对是否可以被 k 整除
 *
 * @author DHW
 * @date 2026/10/22 8:52
 * @Version 1.0
*/
public class ProblemsNo1497 {

    @Test
    public void solution() {
        int[] nums = new int[]{2536,1613,3366,162};
        int k = 2;
        System.out.println("res = " + canArrange(nums, k));
    }

    public boolean canArrange(int[] arr, int k) {
        int[] counts = new int[k];
        for (int num : arr) {
            counts[(num % k + k) % k]++;
        }
        if(counts[0] % 2 != 0) {
            return false;
        }
        for (int i = 1; i <= k / 2; i++) {
            if(counts[i] != counts[k - i]) {
                return false;
            }
        }
        return true;
    }
}

