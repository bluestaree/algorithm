package com.leetcode._2024_5;

import org.junit.Test;


/**
 * 1535. 找出数组游戏的赢家
 *
 * @author DHW
 * @date 2024/5/19 10:46
 * @Version 1.0
*/
public class ProblemsNo1535 {

    @Test
    public void solution() {
        int[] arr = new int[]{2,1,3,5,4,6,7};
        int k = 2;
        System.out.println("res = " + getWinner(arr, k));
    }

    public int getWinner(int[] arr, int k) {
        int res = 0,curIndex = 0,nextIndex = 1,num = k;
        while(num > 0 && nextIndex < arr.length) {
            if(arr[curIndex] > arr[nextIndex]) {
                num--;
            } else {
                num = k - 1;
                curIndex = nextIndex;
            }
            res = arr[curIndex];
            nextIndex++;
        }

        return res;
    }
}

