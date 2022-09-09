package com.itheima.week11.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: algo_pro
 * @description:
 * @author: zhanghz001
 * @create: 2021-01-18 09:27
 **/
public class InsertionSort {
    /* 插入排序*/
    public int[] insertionSortReview(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return nums;
        }
        //定义两个索引,
        int preIdx;
        int current;
        for (int i = 1; i < n; i++) {//未排序的最小下标为i
            //当前元素要插入到已排序区间中某个位置去
            current = nums[i];
            preIdx = i - 1;
            while (preIdx >= 0 && nums[preIdx] > current) {
                //比较过程中如果元素大于当前的元素则将元素后移一位
                nums[preIdx + 1] = nums[preIdx];
                preIdx--;
            }
            //比较过程中如果该元素小于等于当前元素,则将当前元素放在该元素后面
            nums[preIdx + 1] = current;
        }
        return nums;
    }
    
    /**
     * 插入排序算法
     * 插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。
     * 我们将数组中的数据分为两个区间，已排序区间和未排序区间。初始已排序区间只有一个元素，就
     * 是数组的第一个元素。插入算法的核心思想是取未排序区间中的元素，在已排序区间中找到合适的
     * 插入位置将其插入，并保证已排序区间数据一直有序。重复这个过程，直到未排序区间中元素为
     * 空，算法结束。
     * *
     * 步骤：
     * 1：从第一个元素开始，该元素可以认为已经被排序；
     * 2：取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * 3：如果该元素（已排序）大于新元素，将该元素移到下一位置；
     * 4：重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     * 5：将新元素插入到该位置后；
     * 6：重复步骤2~5。
     */
    public int[] insertionSort(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return nums;
        }
        //插入排序
        int curr;
        int preIdx;
        for (int i = 1; i < len; i++) {
            curr = nums[i];
            preIdx = i - 1;
            while (preIdx >= 0 && nums[preIdx] > curr) {
                nums[preIdx + 1] = nums[preIdx];
                preIdx--;
            }
            nums[preIdx + 1] = curr;
        }
        return nums;
    }
    
    @Test
    public void testInsertionSort() {
        
        int[] data = new int[]{5, 2, 6, 5, 9, 0, 3};
        System.out.println("排序前:" + Arrays.toString(data));
        insertionSort(data);
        // insertionSortReview(data);
        System.out.println("排序后:" + Arrays.toString(data));
    }
}
