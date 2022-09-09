package com.itheima.week6.binary_search;

import org.junit.Test;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2020-12-14 09:14
 **/
public class BinarySearchTest {
    
    @Test
    public void test367有效的完全平方数() {
        int num = 2147483647;
        System.out.println(isPerfectSquare(2147483647));
    }
    
    public boolean isPerfectSquare(int num) {
        //
        long left = 0;
        long right = num;
        long mid;
        while (left <= right) {
            mid = (left + right) >> 1;
            long twice = mid * mid;
            if (twice > num) {
                right = mid - 1;
            } else if (twice < num) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
    
    @Test
    public void test33搜索旋转排序数组() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 5;
        System.out.println(search(nums, target));
        System.out.println(search(nums, 0));
    }
    
    public int search(int[] nums, int target) {
        //初始值判断
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        //找到转折点的下标
        int mask = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] < nums[i - 1]) {
                mask = i - 1;
                break;
            }
        }
        //看看target是在左边的升序还是右边的升序
        int left;
        int right;
        if (nums[0] > target) {
            //右边升序
            left = mask + 1;
            right = nums.length - 1;
        } else if (nums[0] < target) {
            left = 0;
            right = mask;
        } else {
            return 0;
        }
        
        //二分查找
        int mid;
        while (left <= right) {
            mid = (left + right) >> 1;
            int val = nums[mid];
            if (val > target) {
                right = mid - 1;
            } else if (val < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        //
        return -1;
        
    }
    
    @Test
    public void test153寻找旋转排序数组中的最小值() {
        // int[] nums = {4, 5, 6, 7, 0, 1, 2};
        // int[] nums = {0, 1, 2, 4, 5, 6, 7};
        int[] nums = {3, 1, 2};
        System.out.println(findMin(nums));
    }
    
    public int findMin(int[] nums) {
        //二分查找
        int l = 0;
        int r = nums.length - 1;
        int mid;
        while (l < r) {
            mid = (l + r) >> 1;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else if (nums[mid] < nums[r]) {
                r = mid;
            }
        }
        return nums[l];
    }
    
    @Test
    public void test74搜索二维矩阵() {
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        // int target = 13;
        int target = 11;
        System.out.println(searchMatrix(matrix, target));
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        // 
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = m * n - 1;
        int mid;
        while (l <= r) {
            mid = (l + r) >> 1;
            int val = matrix[mid / n][mid % n];
            if (val > target) {
                r = mid - 1;
            } else if (val < target) {
                l = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
    
    @Test
    public void testLCP18早餐组合() {
        //比较简单,就不写了
    }
}
