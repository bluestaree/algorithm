package com.leetcode._2026_3;

import org.junit.Test;


/**
 * 26. 删除有序数组中的重复项
 *
 * @author DHW
 * @date 2026/3/26 9: 32
 * @Version 1.0
 */
public class ProblemsNo26 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,1,2};
        System.out.println("res = " + removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int ans = 1;
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                nums[++index] = nums[i];
                ans++;
            }
        }
        return ans;
    }

}

