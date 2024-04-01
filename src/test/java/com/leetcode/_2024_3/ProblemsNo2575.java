package com.leetcode._2024_3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;


/**
 * 2575. 找出字符串的可整除数组
 *
 * @author DHW
 * @date 2024/3/7 9:14
 * @Version 1.0
*/
public class ProblemsNo2575 {

    @Test
    public void solution() {
        int m = 6;
        String word = "aaa";
        System.out.println("res = " + divisibilityArray(word, m));
    }

    public int[] divisibilityArray(String word, int m) {
        int[] res = new int[word.length()];
        char[] charArray = word.toCharArray();
        long num = 0;
        for (int i = 0; i < charArray.length; i++) {
            num = (num * 10 + (charArray[i] - '0')) % m;
            if(num == 0) {
                res[i] = 1;
            }
        }
        return res;
    }

}

