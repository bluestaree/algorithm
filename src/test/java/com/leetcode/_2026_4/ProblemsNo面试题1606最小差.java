package com.leetcode._2026_4;

import org.junit.Test;

import java.util.Arrays;


/**
 * 面试题 16.06. 最小差
 *
 * @author DHW
 * @date 2026/4/13 8: 42
 * @Version 1.0
 */
public class ProblemsNo面试题1606最小差 {

    @Test
    public void solution() {
        int[] a = new int[]{1,2,11,15};
        int[] b = new int[]{4,12,19,23,127,235};
        System.out.println("sortArrayByParity(nums) = " + smallestDifference(a, b));
    }

    public int smallestDifference(int[] a, int[] b) {
        long ans = Integer.MAX_VALUE;
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0, j = 0; i < a.length && j < b.length;) {
            if (a[i] == b[j]) return 0;
            ans = Math.min(ans, Math.abs((long) a[i] - (long) b[j]));
            if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }

        return (int)ans;
    }
}

