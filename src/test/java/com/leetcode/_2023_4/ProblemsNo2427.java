package com.leetcode._2023_4;

import org.junit.Test;


/**
 * 2427. 公因子的数目
 *
 * @author DHW
 * @date 2023/4/5 10:53
 * @Version 1.0
*/
public class ProblemsNo2427 {

    @Test
    public void solution() {
        int a = 32;
        int b = 408;
        System.out.println("res = " + commonFactors(a, b));
    }

    public int commonFactors(int a, int b) {
        int res = 1;
        int num = a > b ? b : a;
        for (int i = 2; i <= num; i++) {
            if(a % i == 0 && b % i == 0) {
                res++;
            }
        }
        return res;
    }
}
