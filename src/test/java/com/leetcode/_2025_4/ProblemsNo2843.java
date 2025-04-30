package com.leetcode._2025_4;

import org.junit.Test;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import java.util.HashSet;
import java.util.Set;


/**
 * 2843. 统计对称整数的数目
 *
 * @author DHW
 * @date 2025/4/11 9: 07
 * @Version 1.0
*/
public class ProblemsNo2843 {

    @Test
    public void solution() {
        int low = 2;
        int high = 3;
        System.out.println("res = " + countSymmetricIntegers(low, high));
    }

    public int countSymmetricIntegers(int low, int high) {
        int res = 0;
        for (int i = low; i <= high; i++) {
            res += f(i);
        }
        return res;
    }

    private int f(int num) {
        String snum = num + "";
        int len = snum.length();
        if(len % 2 != 0) {
            return 0;
        }
        int a = 0;
        int b = 0;
        for (int i = 0; i < len / 2; ++i) {
            a += snum.charAt(i) - '0';
        }
        for (int i = len / 2; i < len; ++i) {
            b += snum.charAt(i) - '0';
        }
        return a == b ? 1 : 0;
    }
}

