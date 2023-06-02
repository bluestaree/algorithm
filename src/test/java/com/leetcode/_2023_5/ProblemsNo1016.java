package com.leetcode._2023_5;

import org.junit.Test;


/**
 * 1016. 子串能表示从 1 到 N 数字的二进制串
 *
 * @author DHW
 * @date 2023/5/11 9:37
 * @Version 1.0
*/
public class ProblemsNo1016 {

    @Test
    public void solution() {
        String s = "001001";
        int n = 2;
        System.out.println("res = " + queryString(s, n));
    }

    public boolean queryString(String s, int n) {
        for(int i = 1; i <= n; ++i){
            if(!s.contains(Integer.toBinaryString(i)))
                return false;
        }
        return true;
    }
}
