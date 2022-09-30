package com.leetcode._2022_9;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;


/**
 * 1709. 第 k 个数
 *
 * @author DHW
 * @date 2022/9/28 9:48
 * @Version 1.0
*/
public class ProblemsNo1709 {

    @Test
    public void solution() {
        System.out.println("true = " + getKthMagicNumber(7));
    }

    public int getKthMagicNumber(int k) {
        if(k == 1) {
            return k;
        }
        // 标记位下标
        int scoreIndex = 0;
        int factorIndex = 0;
        int[] score = new int[]{3,5,7};
        int[] result = new int[k];
        result[0] = 1;
        for (int i = 1; i < k; i++) {
            result[i] = result[factorIndex] * score[scoreIndex];
            scoreIndex += 1;
            if(scoreIndex == 3) {
                // 重置
                factorIndex += 1;
                scoreIndex = 0;
            }
        }
        return result[k-1];
    }

    public int getKthMagicNumber2(int k) {
        int index1 = 0, index2 = 0, index3 = 0;
        int[] result = new int[k];
        result[0] = 1;
        for(int i = 1; i < k; i++) {
            int minValue = Math.min(Math.min(3 * result[index1], 5 * result[index2]), 7 * result[index3]);
            if (minValue == 3 * result[index1]) index1++;
            if (minValue == 5 * result[index2]) index2++;
            if (minValue == 7 * result[index3]) index3++;
            result[i] = minValue;
        }
        return result[k - 1];
    }
}
