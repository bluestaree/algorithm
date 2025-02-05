package com.leetcode._2025_1;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3019. 按键变更的次数
 *
 * @author DHW
 * @date 2022/1/7 8: 49
 * @Version 1.0
*/
public class ProblemsNo3019 {

    @Test
    public void solution() {
        String s = "aAbBcC";
        System.out.println("res = " + countKeyChanges(s));
    }

    public int countKeyChanges(String s) {
        char[] array = s.toLowerCase().toCharArray();
        int res = 0;
        for (int i = 1; i < array.length; i++) {
            if(array[i] != array[i-1]){
                res++;
            }
        }
        return res;
    }
}

