package com.leetcode._2025_5;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


/**
 * 1550. 存在连续三个奇数的数组
 *
 * @author DHW
 * @date 2025/5/11 10: 30
 * @Version 1.0
*/
public class ProblemsNo1550 {

    @Test
    public void solution() {
        int[] nums = new int[]{2,3,12,0,4,6,7};
        System.out.println("res = " + threeConsecutiveOdds(nums));
    }

    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 2; i < arr.length; i++) {
            if (arr[i - 2] % 2 != 0 && arr[i - 1] % 2 != 0 && arr[i] % 2 != 0) {
                return true;
            }
        }
        return false;
    }
}

