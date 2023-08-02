package com.leetcode._2023_7;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2544. 交替数字和
 *
 * @author DHW
 * @date 2023/7/12 9:33
 * @Version 1.0
*/
public class ProblemsNo2544 {

    @Test
    public void solution() {
        int n = 886996;
        System.out.println("res = " + alternateDigitSum(n));
    }

    public int alternateDigitSum(int n) {
        int res = 0, sign = 1;
        while (n > 0) {
            res += n % 10 * sign;
            sign = -sign;
            n /= 10;
        }
        return -sign * res;
    }


    public int alternateDigitSum1(int n) {
        int res = 0;
        int nums[] = new int[10];

        for (int i = 0; i < 10; i++) {
            int num = (int) (n / Math.pow(10,i) % 10);
            nums[i] = num;
        }
        int x = -1;
        boolean start = false;
        for (int i = 9; i >= 0; i--) {
            if(res != 0 && !start) {
                start = true;
            }
            if(start) {
                nums[i] *= x;
                x *= -1;
            }
            res += nums[i];
        }
        return res;
    }

}
