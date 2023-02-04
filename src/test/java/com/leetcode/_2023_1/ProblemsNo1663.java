package com.leetcode._2023_1;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


/**
 * 1663. 具有给定数值的最小字符串
 *
 * @author DHW
 * @date 2023/1/26 10:08
 * @Version 1.0
*/
public class ProblemsNo1663 {

    @Test
    public void solution() {
        int n = 5;
        int k = 31;
        System.out.println("res = " + getSmallestString(n, k));
    }

    public String getSmallestString(int n, int k) {
        char[] result = new char[n];
        for (int i = 0; i < result.length; i++) {
            result[i] = 'a';
        }
        k -= n;
        if(k == 0) {
            return new String(result);
        }
        for (int i = result.length - 1; i >= 0; i--) {
            int num = k - (result[i] - 96);
            if(num >= 25) {
                result[i] = 'z';
                k -= 25;
                continue;
            } else {
                result[i] = (char)('a' + num + 1);
                break;
            }
        }
        return new String(result);
    }
}