package com.leetcode._2022_10;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * 779. 第K个语法符号
 *
 * @author DHW
 * @date 2022/10/20 17:09
 * @Version 1.0
*/
public class ProblemsNo779 {

    @Test
    public void solution() {
        System.out.println("arr = " + kthGrammar(5,3));
    }

    public int kthGrammar(int n, int k) {
//        0  01  0110 01101001 0110100110010110
        int pow = (int) Math.pow(2, n - 1);
        int[] num = new int[pow];
        num[0] = 0;
        int l, preIndex ;
        for (int i = 2; i <= n; i++) {
            preIndex = 0;
            l = (int) Math.pow(2, i - 1);
            for (int j = l / 2; j < l; j++) {
                num[j] = num[preIndex] == 1 ? 0 : 1;
                preIndex++;
            }
        }
        return num[k-1];
    }

}
