package com.leetcode._2025_3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 2269. 找到一个数字的 K 美丽值
 *
 * @author DHW
 * @date 2025/3/10 8: 43
 * @Version 1.0
*/
public class ProblemsNo2269 {

    @Test
    public void solution() {
        int num = 12312;
        int k = 2;
        System.out.println("res = " + divisorSubstrings(num, k));
    }

    public int divisorSubstrings(int num, int k) {
        String s = String.valueOf(num);
        int res = 0;
        for (int i = k; i <= s.length(); i++) {
           int x = Integer.parseInt(s.substring(i - k, i));
            if (x > 0 && num % x == 0) {
                res++;
            }
        }
        return res;
    }
}

