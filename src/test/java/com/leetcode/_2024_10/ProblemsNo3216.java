package com.leetcode._2024_10;

import org.junit.Test;


/**
 * 3216. 交换后字典序最小的字符串
 *
 * @author DHW
 * @date 2024/10/30 9: 16
 * @Version 1.0
*/
public class ProblemsNo3216 {

    @Test
    public void solution() {
        String s = "45320";
        System.out.println("res = " + getSmallestString(s));
    }

    public String getSmallestString(String s) {
        char[] array = s.toCharArray();
        for (int i = 1; i < array.length; i++) {
            if(array[i] % 2 == array[i-1] % 2 && array[i-1] > array[i]){
                char temp = array[i-1];
                array[i-1] = array[i];
                array[i] = temp;
                break;
            }
        }
        return new String(array);
    }
}

