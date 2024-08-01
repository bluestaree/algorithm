package com.leetcode._2024_7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 3099. 哈沙德数
 *
 * @author DHW
 * @date 2024/7/3 9:12
 * @Version 1.0
*/
public class ProblemsNo3099 {

    @Test
    public void solution() {
        int x = 18;
        System.out.println("res = " + sumOfTheDigitsOfHarshadNumber(x));
    }

    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int a = 0;
        for (int i = x; i > 0; i /= 10) {
            a += i % 10;
        }
        return x % a == 0 ? a : -1;
    }
}

