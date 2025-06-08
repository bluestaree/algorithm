package com.leetcode._2025_5;

import org.junit.Test;


/**
 * 75. 颜色分类
 *
 * @author DHW
 * @date 2025/5/17 10: 04
 * @Version 1.0
*/
public class ProblemsNo75 {

    @Test
    public void solution() {
        int[] nums = new int[]{2,0,2,1,1,0};
        sortColors(nums);
    }

    public void sortColors(int[] nums) {
        int i = - 1;
        int j = nums.length;
        int k = 0;
        while (k < j) {
            if(nums[k] == 0) {
                swap(nums, ++i, k++);
            } else if (nums[k] == 2) {
                swap(nums, --j, k);
            } else {
                k++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

