package com.leetcode._2023_11;

import org.junit.Test;

import java.util.Arrays;


/**
 * 318. 最大单词长度乘积
 *
 * @author DHW
 * @date 2023/11/6 10:2
 * @Version 1.0
 */
public class ProblemsNo318 {

    @Test
    public void solution() {
        String[] words = new String[]{"abcw","baz","foo","bar","xtfn","abcdef"};
        System.out.println("minimum = " + maxProduct(words));
    }

    public int maxProduct(String[] words) {
        int len = words.length;
        int res = 0;
        int[] f = new int[len];
        for (int i = 0; i < len; i++) {
            char[] array = words[i].toCharArray();
            for (int j = 0; j < array.length; j++) {
                f[i] = f[i] | 1 << (array[j] - 'a');
            }

            for (int j = 0; j < i; j++) {
                if((f[j] & f[i]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}