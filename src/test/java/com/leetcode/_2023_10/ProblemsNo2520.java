package com.leetcode._2023_10;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


/**
 * 2520. 统计能整除数字的位数
 *
 * @author DHW
 * @date 2023/10/26 9:16
 * @Version 1.0
 */
public class ProblemsNo2520 {

    @Test
    public void solution() {
        int num = 0;
        System.out.println("minimum = " + countDigits(num));
    }

    public int countDigits(int num) {
        int temp = num;
        int res = 0;
        while(temp > 0) {
            if(num % (temp % 10) == 0) {
                res++;
            }
            temp = temp / 10;
        }
        return res;
    }
}