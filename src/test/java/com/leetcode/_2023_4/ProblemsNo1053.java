package com.leetcode._2023_4;

import org.junit.Test;


/**
 * 1053. 交换一次的先前排列
 *
 * @author DHW
 * @date 2023/4/3 9:14
 * @Version 1.0
*/
public class ProblemsNo1053 {

    @Test
    public void solution() {
        int[] arr = new int[]{1, 2, 3};
        System.out.println("res = " + prevPermOpt1(arr));
    }

    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        int currentMax = -1;
        int index = -1;
        boolean hasResult = false;
        for (int i = n - 2; i >= 0; i--) {
            if(arr[i + 1] < arr[i]) {
                for (int j = i + 1; j < n; j++)
                    if(arr[i] > arr[j]) {
                        hasResult = true;
                        if (arr[j] > currentMax) {
                            currentMax = arr[j];
                            index = j;
                    }
                }
                if(hasResult) {
                    int tmp = arr[i];
                    arr[i] = arr[index];
                    arr[index] = tmp;
                    return arr;
                }
            }
        }
        return arr;
    }
}
