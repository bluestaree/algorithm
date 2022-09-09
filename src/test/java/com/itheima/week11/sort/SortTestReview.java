package com.itheima.week11.sort;

import org.junit.Test;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2021-10-14 09:56
 **/
public class SortTestReview {
    
    //==========剑指 Offer 45. 把数组排成最小的数=============
    @Test
    public void testOffer剑指Offer45把数组排成最小的数() {
        int[] a = {3, 30, 34, 5, 9};
        // int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        // int[] a = {10, 2};
        System.out.println(minNumber(a));
    }
    
    public String minNumber(int[] nums) {
        //排好序
        int n = nums.length;
        if (n < 2) {
            return "" + nums[0];
        }
        //需要进行快排
        quickSort(nums, 0, n - 1);
        //需要进行返回数据构建
        StringBuilder builder = new StringBuilder();
        //
        for (int num : nums) {
            builder.append(num);
        }
        //
        return builder.toString();
    }
    
    private void quickSort(int[] nums, int left, int right) {
        //终止条件
        if (left >= right) {
            return;
        }
        //当前层处理
        int position = partition(nums, left, right);
        //下一层处理
        quickSort(nums, left, position - 1);
        quickSort(nums, position + 1, right);
    }
    
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left + 1;
        int j = right;
        while (i <= j) {
            while (i <= j && isMinThen(nums[i], pivot)) {
                i++;
            }
            while (i <= j && !isMinThen(nums[j], pivot)) {
                j--;
            }
            if (i < j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        swap(nums, j, left);
        return j;
    }
    
    private boolean isMinThen(int num, int pivot) {
        // num<= pivot 返回true,否则false
        String s1 = "" + num + pivot;
        String s2 = "" + pivot + num;
        return s1.compareTo(s2) <= 0;
    }
    
    private void swap(int[] nums, int j, int i) {
        if (i != j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
    }
}
