package com.leetcode._2024_5;

import org.junit.Test;

import java.util.Arrays;


/**
 * 1652. 拆炸弹
 *
 * @author DHW
 * @date 2024/5/5 15:00
 * @Version 1.0
*/
public class ProblemsNo1652 {

    @Test
    public void solution() {
        int[] code = new int[]{5,7,1,4};
        int k = 3;
        System.out.println("res = " + decrypt(code, k));
    }

    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int a = k > 0 ? 1 : -1;
        k = Math.abs(k);
        int[] res = new int[n];
        for (int i = 0; i < code.length; i++) {
            if(k == 0) {
                res[i] = 0;
            } else {
                int num = 0;
                for (int j = 1; j <= k; j++) {
                    num += code[(i+(j*a)+n) % n];
                }
                res[i] = num;
            }
        }
        return res;
    }
}

