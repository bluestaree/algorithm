package com.leetcode._2025_8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 326. 3 的幂
 *
 * @author DHW
 * @date 2025/8/13 10: 55
 * @Version 1.0
*/
public class ProblemsNo326 {

    @Test
    public void solution() {
        int n = 6;
        System.out.println("res = " + isPowerOfThree(n));
    }

    public boolean isPowerOfThree(int n) {
        while(n > 2) {
            if(n % 3 != 0) {
                return false;
            }
            n /= 3;
        }
        return n == 1;
    }
}

