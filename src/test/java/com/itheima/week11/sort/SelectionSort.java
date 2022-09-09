package com.itheima.week11.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2021-01-18 09:27
 **/
public class SelectionSort {
    
    public int[] selectionSortReview(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return nums;
        }
        //选择排序
        
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }
            //i,minIdx交换
            swap(nums, i, minIdx);
        }
        return nums;
    }
    
    /**
     * 选择排序算法
     * 选择排序算法的实现思路有点类似插入排序，也分已排序区间和未排序区间。但是选择排序每次会
     * 从未排序区间中找到最小的元素，将其放到已排序区间的末尾
     */
    public int[] selectionSort(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return nums;
        }
        //选择排序
        for (int i = 0; i < len - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }
            swap(nums, i, minIdx);
        }
        return nums;
    }
    
    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
        }
    }
    
    @Test
    public void testSelectionSort() {
        
        int[] data = new int[]{5, 2, 6, 5, 9, 0, 3};
        System.out.println("排序前:" + Arrays.toString(data));
        selectionSort(data);
        // selectionSortReview(data);
        System.out.println("排序后:" + Arrays.toString(data));
    }
}
