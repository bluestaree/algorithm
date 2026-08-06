package com.leetcode._2026_7;

import org.junit.Test;

import java.util.Arrays;


/**
 * 1385. 两个数组间的距离值
 *
 * @author DHW
 * @date 2026/7/17 9: 50
 * @Version 1.0
 */
public class ProblemsNo1385 {

    @Test
    public void solution() {
        int[] arr1 = new int[]{1,3,5,6};
        int[] arr2 = new int[]{1,3,5,6};
        int d = 2;
        System.out.println("= res = " + findTheDistanceValue(arr1, arr2, d));
    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;
        Arrays.sort(arr2);
        for (int x : arr1) {
            int low = x - d;
            int high = x + d;
            if(!search(arr2, low ,high)) {
                ans++;
            }
        }
        return ans;
    }

    private boolean search(int[] arr, int low, int high) {
        int left = 0;
        int right = arr.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] >= low && arr[mid] <= high) {
                return true;
            } else if(arr[mid] < low) {
                left = mid + 1;

            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}

