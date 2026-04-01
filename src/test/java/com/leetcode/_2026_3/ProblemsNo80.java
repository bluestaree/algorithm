package com.leetcode._2026_3;

import org.junit.Test;


/**
 * 80. 删除有序数组中的重复项 II
 *
 * @author DHW
 * @date 2026/3/26 9: 37
 * @Version 1.0
 */
public class ProblemsNo80 {

    @Test
    public void solution() {
        int[] nums = new int[]{1,1,1,2,2,3};
        System.out.println("res = " + removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int ans = 2;
        int index = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[index - 1]) {
                nums[++index] = nums[i];
                ans++;
            }
        }
        return ans;
    }

}

