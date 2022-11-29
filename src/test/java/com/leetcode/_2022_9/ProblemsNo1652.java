package com.leetcode._2022_9;

import org.junit.Test;

import java.util.Arrays;


/**
 * 1652. 拆炸弹
 *
 * @author DHW
 * @date 2022/9/24 12:44
 * @Version 1.0
*/
public class ProblemsNo1652 {

    @Test
    public void solution() {
        int[] code = new int[]{2,4,9,3};
        int k = -2;
        int[] decrypt = decrypt(code, k);
        for (int i : decrypt) {
            System.out.println("i = " + i);
        }
    }

    public int[] decrypt(int[] code, int k) {
        int[] ints = new int[code.length];
        if(k == 0) {
            Arrays.fill(ints, 0);
            return ints;
        } else if(k > 0) {
            for (int i = 0; i < code.length; i++) {
                int count = 0;
                for (int l = i + 1; ; l++) {
                    if(count == k) {
                        break;
                    }
                    if(l == code.length) {
                        l = 0;
                    }
                    ints[i] += code[l];
                    count++;
                }
            }
        } else {
            k = -k;
            for (int i = 0; i < code.length; i++) {
                int count = 0;
                for (int l = i - 1; ; l--) {
                    if(count == k) {
                        break;
                    }
                    if(l == -1) {
                        l = code.length - 1;
                    }
                    ints[i] += code[l];
                    count++;
                }
            }
        }
        return ints;
    }
}
