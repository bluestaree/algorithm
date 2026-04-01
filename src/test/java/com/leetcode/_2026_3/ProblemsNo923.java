package com.leetcode._2026_3;

import org.junit.Test;

import java.util.Arrays;


/**
 * 923. 三数之和的多种可能
 *
 * @author DHW
 * @date 2026/3/17 10: 28
 * @Version 1.0
*/
public class ProblemsNo923 {

    @Test
    public void solution() {
        int[] numbers = new int[]{2,2,3,3};
        int target = 5;
        System.out.println("res = " + threeSumMulti(numbers, target));
    }

    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        int ans = 0;
        int mod = 1000000007;
        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            int x = arr[i];
            int s = x + arr[i + 1] + arr[i + 2];
            if (s > target) {
                break;
            }
            s = x + arr[n - 2] + arr[n - 1];
            if (s < target) {
                continue;
            }
            int l = i + 1, r = n - 1;
            while (l < r) {
                int sum = x + arr[l] + arr[r];
                if (sum == target) {
                    if (arr[l] == arr[r]) {
                        int m = r - l + 1;
                        ans += m * (m - 1) / 2;
                        ans %= mod;
                        break;
                    } else {
                        int lc = 1, rc = 1;
                        while (l < r && arr[l] == arr[l + 1]) {
                            lc++;
                            l++;
                        }
                        while (r > l && arr[r] == arr[r - 1]) {
                            rc++;
                            r--;
                        }
                        ans += lc * rc;
                        ans %= mod;
                        l++;
                        r--;
                    }
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return ans;
    }
}

