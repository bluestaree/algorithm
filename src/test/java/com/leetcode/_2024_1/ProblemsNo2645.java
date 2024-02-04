package com.leetcode._2024_1;

import org.junit.Test;

import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.Deque;


/**
 * 2645. 构造有效字符串的最少插入数
 *
 * @author DHW
 * @date 2024/1/11 9:23
 * @Version 1.0
*/
public class ProblemsNo2645 {

    @Test
    public void solution() {
        String word = "aaaa";
        System.out.println("-1%3 = " + addMinimum(word));
    }

    public int addMinimum(String word) {
        char last = 'c';
        int res = 0;
        for (int i = 0; i < word.length(); i++) {
            res += (word.charAt(i) - last + 2)  % 3;
            last = word.charAt(i);
        }
        return res + ('a' - last + 2) % 3;
    }
}

