package com.leetcode._2023_10;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2698. 求一个整数的惩罚数
 *
 * @author DHW
 * @date 2023/10/25 8:53
 * @Version 1.0
*/
public class ProblemsNo2698 {

    @Test
    public void solution() {
        int n = 10;
        System.out.println("res = " + punishmentNumber(n));
    }

    public int punishmentNumber(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int num = i * i;
            if(checkNum(num, i)) {
                res+=num;
            }
        }
        return res;
    }

    private boolean checkNum(int num, int n) {
        if(num < n) {
            return false;
        }
        if(num == n) {
            return true;
        }
        for (int i = 10; i <= num; i*=10) {
            if(checkNum(num / i, n - num % i)) {
                return true;
            }
        }
        return false;
    }


    public int punishmentNumber1(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int num = i * i;
            if(checkNum1(String.valueOf(num), 0, i)) {
                res+=num;
            }
        }
        return res;
    }

    private boolean checkNum1(String target, int i , int n) {
        if(i >= target.length()) {
            return n == 0;
        }
        int y = 0;
        for (int j = i; j < target.length(); j++) {
            y = y * 10 + (target.charAt(j) - '0');
            if(checkNum1(target, j + 1, n - y)) {
                return true;
            }
        }
        return false;
    }
}

