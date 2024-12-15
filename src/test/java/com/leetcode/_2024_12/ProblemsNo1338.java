package com.leetcode._2024_12;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;


/**
 * 1338. 数组大小减半
 *
 * @author DHW
 * @date 2024/12/15 12: 31
 * @Version 1.0
*/
public class ProblemsNo1338 {

    @Test
    public void solution() {
        int[] arr = new int[]{7,4,1};
        System.out.println("res = " + minSetSize(arr));
    }

    public int minSetSize(int[] arr) {
        int mx = 0;
        for (int x : arr) {
            mx = Math.max(mx, x);
        }
        int[] cnt = new int[mx + 1];
        for (int x : arr) {
            ++cnt[x];
        }
        Arrays.sort(cnt);
        int res = 0;
        int m = 0;
        for (int i = mx;; --i) {
            if (cnt[i] > 0) {
                m += cnt[i];
                ++res;
                if (m * 2 >= arr.length) {
                    return res;
                }
            }
        }
    }
}

