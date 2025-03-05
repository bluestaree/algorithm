package com.leetcode._2025_2;

import org.junit.Test;


/**
 * 2595. 奇偶位数
 *
 * @author DHW
 * @date 2025/2/20 9:24
 * @Version 1.0
 */
public class ProblemsNo2595 {

    @Test
    public void solution() {

        int n = 2;
        System.out.println("res = " + evenOddBit(n));
    }

    public int[] evenOddBit(int n) {
        int[] res = new int[2];
        String binaryString = Integer.toBinaryString(n);
        for (int i = binaryString.length() - 1, j = 0; i >= 0; i--, j++) {
            if(binaryString.charAt(i) == '1') {
                res[j % 2]++;
            }
        }
        return res;
    }
}
