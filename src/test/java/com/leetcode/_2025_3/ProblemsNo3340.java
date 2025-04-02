package com.leetcode._2025_3;

import org.junit.Test;


/**
 * 3340. 检查平衡字符串
 *
 * @author DHW
 * @date 2025/3/14 8: 48
 * @Version 1.0
*/
public class ProblemsNo3340 {

    @Test
    public void solution() {
        String num = "ieaouqqieaouqq";
        System.out.println("res = " + isBalanced(num));
    }

    public boolean isBalanced(String num) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < num.length(); i+=2) {
            a += (num.charAt(i) - '0');
        }
        for (int i = 1; i < num.length(); i+=2) {
            b += (num.charAt(i) - '0');
        }
        return a == b;
    }
}

