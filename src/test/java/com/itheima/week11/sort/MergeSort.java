package com.itheima.week11.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2021-01-18 09:27
 **/
public class MergeSort {
    
    public int[] mergeSortReview(int[] nums) {
        //初始条件
        int n = nums.length;
        if (n < 2) {
            return nums;
        }
        //递归
        merge = new int[n];
        dfsMerge(nums, 0, n - 1);
        return nums;
    }
    
    int[] merge;
    
    private void dfsMerge(int[] nums, int left, int right) {
        //终止条件
        if (left >= right) {
            return;
        }
        //
        int mid = (left + right) / 2;
        dfsMerge(nums, left, mid);
        dfsMerge(nums, mid + 1, right);
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i <= mid && j <= right) {
                if (nums[i] <= nums[j]) {
                    merge[k] = nums[i];
                    i++;
                } else {
                    merge[k] = nums[j];
                    j++;
                }
            } else if (i > mid) {
                merge[k] = nums[j];
                j++;
            } else {
                // if (j > right) 
                merge[k] = nums[i];
                i++;
            }
        }
        //还需要在将temp拷贝会到nums
        System.arraycopy(merge, left, nums, left, right - left + 1);
    }
    
    //归并排序
    int[] temp;//存放每层合并后的结果
    
    /**
     * 归并排序算法
     * 归并排序的核心思想还是蛮简单的。如果要排序一个数组，我们先把数组从中间分成前后两部分，
     * 然后对前后两部分分别排序，再将排好序的两部分合并在一起，这样整个数组就都有序了
     */
    public int[] mergeSort(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return nums;
        }
        temp = new int[len];
        // 归并
        dfs(nums, 0, len - 1);
        return nums;
    }
    
    private void dfs(int[] nums, int left, int right) {
        //terminal
        if (left >= right) {
            return;
        }
        
        //当前层处理
        int mid = left + ((right - left) >> 1);
        dfs(nums, left, mid);
        dfs(nums, mid + 1, right);
        
        //合并升序
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        if (i <= mid) {
            //只剩下i到mid需要合并
            System.arraycopy(nums, i, temp, k, mid + 1 - i);
        }
        if (j <= right) {
            //只剩下j到right需要合并
            System.arraycopy(nums, j, temp, k, right + 1 - j);
        }
        //还需要在将temp拷贝会到nums
        System.arraycopy(temp, 0, nums, left, right - left + 1);
        
    }
    
    @Test
    public void testMergeSort() {
        
        int[] data = new int[]{5, 2, 6, 5, 9, 0, 3};
        System.out.println("排序前:" + Arrays.toString(data));
        // mergeSort(data);
        mergeSortReview(data);
        System.out.println("排序后:" + Arrays.toString(data));
    }
}
