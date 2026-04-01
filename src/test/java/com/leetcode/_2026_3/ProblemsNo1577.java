package com.leetcode._2026_3;

import org.junit.Test;

import java.util.Arrays;


/**
 * 1577. 数的平方等于两数乘积的方法数
 *
 * @author DHW
 * @date 2026/3/17 9: 29
 * @Version 1.0
*/
public class ProblemsNo1577 {

    @Test
    public void solution() {
        int[] nums1 = new int[]{2,2,3,3};
        int[] nums2 = new int[]{2,2,3,3};
        System.out.println("res = " + numTriplets(nums1, nums2));
    }

    public int numTriplets(int[] nums1, int[] nums2) {
        int ans = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if(nums2.length > 2) {
            ans = getAns(nums1, nums2, ans);
        }
        if(nums1.length > 2) {
            ans = getAns(nums2, nums1, ans);
        }
        return ans;
    }

    private static int getAns(int[] nums1, int[] nums2, int ans) {
        for (int i = 0; i < nums1.length; i++) {
            long target = (long) nums1[i] * nums1[i];
            int left = 0, right = nums2.length - 1;
            long x = (long) nums2[nums2.length - 1] * nums2[nums2.length - 2];
            if(x < target) {
                break;
            }
            x = (long) nums2[0] * nums2[1];
            if(x > target) {
                continue;
            }
            while (left < right) {
                long product = (long) nums2[left] * nums2[right];
                if (product == target) {
                    if(nums2[left] == nums2[right]) {
                        int count = right - left + 1;
                        ans += count * (count - 1) / 2;
                        break;
                    }
                    int m = 1;
                    int n = 1;
                    while (left < right && nums2[left] == nums2[left + 1]) {
                        m++;
                        left++;
                    }
                    while (right > left && nums2[right] == nums2[right - 1]) {
                        n++;
                        right--;
                    }
                    ans += m * n;
                    left++;
                    right--;
                } else if (product < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return ans;
    }
}

