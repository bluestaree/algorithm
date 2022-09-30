package com.leetcode._2022_9;

import org.junit.Test;

import java.util.Arrays;


/**
 * 1608. 特殊数组的特征值
 * shift-2d-grid
 *
 * @author DHW
 * @date 2022/9/12 12:22
 * @Version 1.0
*/
public class ProblemsNo1608 {

    @Test
    public void solution() {
        int[] data = new int[]{3,6,7,7,0};
//        System.out.println("排序前:" + Arrays.toString(data));
//        bubbleSort(data);
//        System.out.println("排序后:" + Arrays.toString(data));
        int i = specialArray(data);
        System.out.println(i);
    }

    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        for (int i = 1; i <= n; ++i) {
            if (nums[i - 1] >= i && (i == n || nums[i] < i)) {
                return i;
            }
        }
        return -1;
    }
}
