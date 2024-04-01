package com.leetcode._2024_3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;


/**
 * 2834. 找出美丽数组的最小和
 *
 * @author DHW
 * @date 2024/3/8 9:03
 * @Version 1.0
*/
public class ProblemsNo2834 {

    @Test
    public void solution() {
        int n = 37;
        int target = 46;
        System.out.println("res = " + minimumPossibleSum(n, target));
    }

    public int minimumPossibleSum(int n, int target) {
        final int MOD = 1000000007;
        long k1 = Math.min(n, target / 2);   // [1, target - 1]内提供的元素个数
        long k2 = n - k1;               	// [target, ...)提供的元素个数
        return (int)(((1 + k1) * k1 + (2 * target + k2 - 1) * k2) / 2 % MOD);
    }

}

