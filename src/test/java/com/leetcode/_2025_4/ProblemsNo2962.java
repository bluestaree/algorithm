package com.leetcode._2025_4;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;


/**
 * 2962. 统计最大元素出现至少 K 次的子数组
 *
 * @author DHW
 * @date 2025/4/29 8: 32
 * @Version 1.0
*/
public class ProblemsNo2962 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,3,2,3,3};
        System.out.println("res = " + countSubarrays(nums, 2));
    }

    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int max = Arrays.stream(nums).max().getAsInt();
        long res = 0;

        int r = 0;
        int count = 0;
        for (int l = 0; l <= n - k; l++) {
            for (; r < n; r++) {
                if(nums[r] == max && ++count == k) {
                    long num = 1;
                    while(nums[l] != max) {
                        l++;
                        num++;
                    }
                    res += (n - r) * num;
                    r++;
                    count--;
                    break;
                }
            }
        }
        return res;
    }

}

