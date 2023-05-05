package com.leetcode._2023_4;

import org.junit.Test;


/**
 * 1017. 负二进制转换
 *
 * @author DHW
 * @date 2023/4/6 13:52
 * @Version 1.0
*/
public class ProblemsNo1017 {

    @Test
    public void solution() {
        int n = 6;
        System.out.println("res = " + baseNeg2(n));
    }

    public String baseNeg2(int n) {
        if(n == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            // 商
            int rs = n / -2;
            // 余数
            int i = n - (-2 * rs);
            if(i < 0) {
                // 商+1 ，强制转换余数 -1 -> 1
                rs++;
                i = n - (-2 * rs);
            }
            sb.append(i);
            n = rs;
        }
        return sb.reverse().toString();
    }
}
