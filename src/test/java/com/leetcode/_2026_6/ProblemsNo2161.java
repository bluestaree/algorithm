package com.leetcode._2026_6;

import org.junit.Test;

import java.util.ArrayList;


/**
 * 2161. 根据给定数字划分数组
 *
 * @author DHW
 * @date 2026/6/8 8: 51
 * @Version 1.0
 */
public class ProblemsNo2161 {

    @Test
    public void solution() {
        int[] nums = new int[]{3,2,1};
        int pivot = 2;
        System.out.println("= res = " + pivotArray(nums, pivot));
    }

    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();
        for (int num : nums) {
            if (num == pivot) {
                equal.add(num);
            } else if (num > pivot) {
                right.add(num);
            } else {
                left.add(num);
            }
        }
        int[] ans = new int[n];
        int i = 0;
        for (Integer num : left) {
            ans[i++] = num;
        }
        for (Integer num : equal) {
            ans[i++] = num;
        }
        for (Integer num : right) {
            ans[i++] = num;
        }
        return ans;
    }
}

