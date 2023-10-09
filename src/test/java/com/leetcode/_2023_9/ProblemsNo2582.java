package com.leetcode._2023_9;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * 2582. 递枕头
 *
 * @author DHW
 * @date 2023/9/26 9:42
 * @Version 1.0
*/
public class ProblemsNo2582 {

    @Test
    public void solution() {
        int n = 1;
        int time = 2;
        System.out.println("res = " + passThePillow(n, time));
    }

    public int passThePillow(int n, int time) {
        int k = 1;
        int i = 1;
        while(time-- > 0) {
            i += k;
            if(i == 1 || i == n) {
                k *= -1;
            }
        }
        return i;
    }
}
