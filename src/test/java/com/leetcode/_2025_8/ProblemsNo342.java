package com.leetcode._2025_8;

import org.junit.Test;


/**
 * 326. 4 的幂
 *
 * @author DHW
 * @date 2025/8/15 9: 42
 * @Version 1.0
*/
public class ProblemsNo342 {

    @Test
    public void solution() {
        int n = 6;
        System.out.println("res = " + isPowerOfFour(n));
    }

    public boolean isPowerOfFour(int n) {
        while(n > 3) {
            if(n % 4 != 0) {
                return false;
            }
            n /= 4;
        }
        return n == 1;
    }
}

