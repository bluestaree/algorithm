package com.leetcode._2025_7;

import org.junit.Test;

import java.util.Arrays;


/**
 * 1394. 找出数组中的幸运数
 *
 * @author DHW
 * @date 2025/7/5 10: 25
 * @Version 1.0
*/
public class ProblemsNo1394 {

    @Test
    public void solution() {
        int[] arr = new int[]{1,2,2,3,3,3};
        System.out.println("res = " + findLucky(arr));
    }

    public int findLucky(int[] arr) {
        int[] cnt = new int[501];
        for (int x : arr) {
            ++cnt[x];
        }
        for (int x = cnt.length - 1; x > 0; --x) {
            if (x == cnt[x]) {
                return x;
            }
        }
        return -1;
    }
}

