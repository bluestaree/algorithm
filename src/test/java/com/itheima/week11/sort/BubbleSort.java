package com.itheima.week11.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: algo_pro
 * @description:冒泡
 * @author: zhanghz001
 * @create: 2021-01-18 09:27
 **/
public class BubbleSort {
    
    /**
     * 冒泡排序算法
     * 冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺
     * 序错误就把它们交换过来。
     * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
     * 这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端
     * *
     * 步骤:
     * 1：比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * 2：对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是
     * 最大的数；
     * 3：针对所有的元素重复以上的步骤，除了最后一个；
     * 4：重复步骤1~3，直到排序完成。
     */
    public int[] bubbleSort(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return nums;
        }
        
        //冒泡,没有优化的时候
        // for (int i = len - 1; i > 0; i--) {
        //     for (int j = 0; j < i; j++) {
        //         if (nums[j] > nums[j + 1]) {
        //             //异或交换
        //             nums[j] ^= nums[j + 1];
        //             nums[j + 1] ^= nums[j];
        //             nums[j] ^= nums[j + 1];
        //         }
        //     }
        // }
        
        //冒泡优化
        boolean flag = true;
        for (int i = len - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    //异或交换
                    nums[j] ^= nums[j + 1];
                    nums[j + 1] ^= nums[j];
                    nums[j] ^= nums[j + 1];
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return nums;
    }
    
    /**
     * 复习的时候写的
     *
     * @param nums
     * @return
     */
    public int[] bubbleSortReview(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return nums;
        }
        //冒泡
        for (int i = n - 1; i > 0; i--) {
            boolean flag = true;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    //交换
                    nums[j] ^= nums[j + 1];
                    nums[j + 1] ^= nums[j];
                    nums[j] ^= nums[j + 1];
                    flag = false;
                }
            }
            //循环下来没有需要交换的东西,说明已经排序好了
            if (flag) {
                break;
            }
        }
        return nums;
    }
    
    @Test
    public void testBubbleSort() {
        
        int[] data = new int[]{5, 2, 6, 5, 9, 0, 3};
        System.out.println("排序前:" + Arrays.toString(data));
        bubbleSort(data);
        // bubbleSortReview(data);
        System.out.println("排序后:" + Arrays.toString(data));
    }
    
}
