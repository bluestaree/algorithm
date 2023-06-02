package com.leetcode._2023_5;

import org.junit.Test;

import javax.swing.plaf.metal.MetalIconFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * 1015. 可被 K 整除的最小整数
 *
 * @author DHW
 * @date 2023/5/10 9:18
 * @Version 1.0
*/
public class ProblemsNo1015 {

    @Test
    public void solution() {
        int k = 2;
        System.out.println("res = " + smallestRepunitDivByK(k));
    }

    public int smallestRepunitDivByK(int k) {
        int n = 1 % k;
        for (int i = 1; i <= k; i++) {
            if(n == 0) {
                return i;
            }
            n = (n * 10 + 1) % k;
        }
        return -1;
    }
}
