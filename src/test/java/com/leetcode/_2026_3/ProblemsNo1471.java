package com.leetcode._2026_3;

import org.junit.Test;

import java.util.Arrays;


/**
 * 1471. 数组中的 k 个最强值
 *
 * @author DHW
 * @date 2026/3/6 9: 08
 * @Version 1.0
*/
public class ProblemsNo1471 {

    @Test
    public void solution() {
        int[] arr = new int[]{2,2,3,3};
        int k = 5;
        System.out.println("res = " + getStrongest(arr, k));
    }

    public int[] getStrongest(int[] arr, int k) {
        int[] ans = new int[k];
        Arrays.sort(arr);
        int mid = arr[(arr.length - 1) / 2];
        int left = 0, right = arr.length - 1;
        int index = 0;
        while (index < k) {
            if(Math.abs(arr[left] - mid) > Math.abs(arr[right] - mid)){
                ans[index++] = arr[left++];
            } else {
                ans[index++] = arr[right--];
            }
        }
        return ans;
    }

}

