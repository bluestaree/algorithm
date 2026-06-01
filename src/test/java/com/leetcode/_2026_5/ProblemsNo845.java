package com.leetcode._2026_5;

import org.junit.Test;

import java.util.Arrays;


/**
 * 845. 数组中的最长山脉
 *
 * @author DHW
 * @date 2026/5/21 10: 36
 * @Version 1.0
 */
public class ProblemsNo845 {

    @Test
    public void solution() {
        int[] arr = new int[]{0,1,2,3,4,5,4,3,2,1,0};
        System.out.println("res = " + longestMountain(arr));
    }

    public int longestMountain(int[] arr) {
        int ans = 0;
        int n = arr.length;
        int i = 0;
        while(i < n) {
            int start = i;
            while(i + 1 < n && arr[i] < arr[i+1]) {
                i++;
            }
            int top = i;

            while(top > start && i + 1 < n && arr[i] > arr[i+1]) {
                i++;
            }

            if (top > start && i > top) {
                ans = Math.max(ans, i + 1 - start);
            }

            if (start == i) {
                i++;
            }
        }
        return ans;
    }

}

