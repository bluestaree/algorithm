package com.leetcode._2023_12;

import org.junit.Test;


/**
 * 2697. 字典序最小回文串
 *
 * @author DHW
 * @date 2023/12/13 9:32
 * @Version 1.0
*/
public class ProblemsNo2697 {

    @Test
    public void solution() {
        String s = ":";


        System.out.println("res = " + makeSmallestPalindrome(s));
    }

    public String makeSmallestPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] array = s.toCharArray();
        while(left < right) {
            if(array[left] > array[right]) {
                array[left] = array[right];
            }
            if(array[left] < array[right]) {
                array[right] = array[left];
            }
            left++;
            right--;
        }
        return new String(array);
    }
}

