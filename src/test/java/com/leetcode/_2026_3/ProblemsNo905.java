package com.leetcode._2026_3;

import org.junit.Test;


/**
 * 905. 按奇偶排序数组
 *
 * @author DHW
 * @date 2026/3/31 10: 02
 * @Version 1.0
 */
public class ProblemsNo905 {

    @Test
    public void solution() {
        int[] nums = new int[]{0,1,0,3,12};
        System.out.println("sortArrayByParity(nums) = " + sortArrayByParity(nums));
    }


    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int left = 0;
        int right = n - 1;
        for (int num : nums) {
            if(num % 2 == 0) {
                ans[left++] = num;
            } else {
                ans[right--] = num;
            }
        }
        return ans;
    }

}

