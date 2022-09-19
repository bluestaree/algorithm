package com.leetcode;

import org.junit.Test;

import java.util.Arrays;


/**
 * 1619. 删除某些元素后的数组均值
 *
 * @author DHW
 * @date 2022/9/14 8:38
 * @Version 1.0
*/
public class ProblemsNo1619 {

    @Test
    public void solution() {
        int[] data = new int[]{6,0,7,0,7,5,7,8,3,4,0,7,8,1,6,8,1,1,2,4,8,1,9,5,4,3,8,5,10,8,6,6,1,0,6,10,8,2,3,4};
//        System.out.println("排序前:" + Arrays.toString(data));
//        bubbleSort(data);
//        System.out.println("排序后:" + Arrays.toString(data));
        System.out.println("data = " + trimMean(data));

    }

    public double trimMean(int[] arr) {
        // 冒泡排序
//        bubbleSort(arr);
        Arrays.sort(arr);
        // 获取字符串长度
        int length = arr.length;
        int factor = length / 20 ;
        // 统计
        int sum = 0;
        for (int i = factor; i < length - factor; i++) {
            // 统计
            sum += arr[i];
        }

        return sum / (double)(length - factor * 2);
    }

    private void bubbleSort(int[] arr) {
        boolean flag = false;
        int len  = arr.length;
        for (int i = len - 1; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[j+1]) {
                    // 交换
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag) {
                break;
            }
        }
    }

}
