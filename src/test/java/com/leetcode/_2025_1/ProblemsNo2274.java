package com.leetcode._2025_1;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2274. 不含特殊楼层的最大连续楼层数
 *
 * @author DHW
 * @date 2022/1/6 8: 31
 * @Version 1.0
*/
public class ProblemsNo2274 {

    @Test
    public void solution() {
        int bottom = 2;
        int top = 10;
        int[] special = new int[]{4,6};
        System.out.println("res = " + maxConsecutive(bottom, top, special));
    }

    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int n = special.length;
        int res = 0;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, special[i] - special[i-1] - 1);
        }
        return Math.max(res, Math.max(special[0] - bottom, top - special[n - 1]));
    }
}

