package com.leetcode._2022_11;

import org.junit.Test;


/**
 * 1758. 生成交替二进制字符串的最少操作数
 *
 * @author DHW
 * @date 2022/11/29 9:52
 * @Version 1.0
*/
public class ProblemsNo1758 {

    @Test
    public void solution() {
        String s = "10010100";
        System.out.println("res = " + minOperations(s));
    }

    public int minOperations(String s) {
        int a = 0, n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 1; i < n; i++) {
            if(arr[i] == arr[i-1]) {
                a++;
                arr[i] = (char) (arr[i-1] ^ 1);
            }
        };
        return Math.min(a, n - a);
    }
}
