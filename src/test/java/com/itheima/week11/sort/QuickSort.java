package com.itheima.week11.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2021-01-21 09:22
 **/

public class QuickSort {
    @Test
    public void testQuickSort() {
        
        int[] data = new int[]{5, 2, 6, 5, 9, 0, 3};
        System.out.println("排序前:" + Arrays.toString(data));
        // quickSort(data);
        quickSortReview(data);
        System.out.println("排序后:" + Arrays.toString(data));
    }
    
    public int[] quickSortReview(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return nums;
        }
        quickSortDfs(nums, 0, n - 1);
        return nums;
    }
    
    public void quickSortDfs(int[] nums, int left, int right) {
        //终止条件
        if (left >= right) {
            return;
        }
        //快排,当前层处理
        int position = partitionMethod(nums, left, right);
        
        //下一层处理
        quickSortDfs(nums, left, position - 1);
        quickSortDfs(nums, position + 1, right);
    }
    
    private int partitionMethod(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left + 1;
        int j = right;
        while (i <= j) {
            //j从右向左,遇到比pivot大的跳过,直到找到比pivot小的元素,停下
            while (i <= j && nums[i] < pivot) {
                i++;
            }
            //i从左向右,遇到比pivot小的跳过,直到找到比pivot大的元素,停下
            while (j >= i && nums[j] > pivot) {
                j--;
            }
            
            if (i < j) {
                //交换
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        //i>=j, left==j相等 不交换,不相等交换
        swap(nums, left, j);
        return j;
    }
    
    /**
     * https://visualgo.net
     * 快速排序算法
     * 1：从数列中挑出一个元素，称为 “基准”（pivot）；
     * 2：重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后
     * 面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区
     * （partition）操作；
     * 3：递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     */
    public int[] quickSort(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return nums;
        }
        //快排
        quickSort(nums, 0, len - 1);
        return nums;
    }
    
    private void quickSort(int[] nums, int left, int right) {
        //terminal
        if (left >= right) {
            return;
        }
        //当前层
        int position = partition(nums, left, right);
        
        //下一层
        quickSort(nums, left, position - 1);
        quickSort(nums, position + 1, right);
        
    }
    
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left + 1;
        int j = right;
        for (; ; ) {
            // System.out.println("i: " + i + " j: " + j);
            while (i <= j && nums[i] < pivot) {
                i++;
            }
            while (i <= j && nums[j] > pivot) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
            i++;
            j--;
        }
        swap(nums, left, j);
        return j;
    }
    
    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
        }
    }
    
    public int findKthLargest(int[] nums, int k) {
        //len-k求出即可
        
        int len = nums.length;
        int targetIdx = len - k;
        int left = 0;
        int right = len - 1;
        for (; ; ) {
            int position = partition(nums, left, right);
            if (targetIdx == position) {
                return nums[targetIdx];
            } else if (targetIdx < position) {
                //左边继续递归
                right = position - 1;
            } else {
                //右边继续递归
                left = position + 1;
                
            }
        }
    }
    
}
