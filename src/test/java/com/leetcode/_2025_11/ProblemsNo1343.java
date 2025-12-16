package com.leetcode._2025_11;

import org.junit.Test;


/**
 * 1343. 大小为 K 且平均值大于等于阈值的子数组数目
 *
 * @author DHW
 * @date 2025/11/27 8: 47
 * @Version 1.0
*/
public class ProblemsNo1343 {

    @Test
    public void solution() {
        int[] arr =  new int[]{-1};
        int k = 1;
        int threshold = 1;
        System.out.println("res = " + numOfSubarrays(arr, k, threshold ));
    }

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int l = i - k + 1;
            if(l < 0) {
                continue;
            }
            if(sum / k >= threshold) {
                ans++;
            }
            sum -= arr[l];
        }
        return ans;
    }
}

