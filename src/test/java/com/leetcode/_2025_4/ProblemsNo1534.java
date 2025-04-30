package com.leetcode._2025_4;

import org.junit.Test;


/**
 * 1534. 统计好三元组
 *
 * @author DHW
 * @date 2025/4/14 9: 21
 * @Version 1.0
*/
public class ProblemsNo1534 {

    @Test
    public void solution() {
        int[] nums = new int[]{2,3,12,0,4,6,7};
        int a = 7, b = 2, c = 3;
        System.out.println("res = " + countGoodTriplets(nums, a, b, c));
    }

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b
                            && Math.abs(arr[i] - arr[k]) <= c) {
                        ++ans;
                    }
                }
            }
        }
        return ans;
    }
}

