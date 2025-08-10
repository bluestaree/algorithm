package com.leetcode._2025_8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 869. 重新排序得到 2 的幂
 *
 * @author DHW
 * @date 2025/8/10 10: 36
 * @Version 1.0
*/
public class ProblemsNo869 {

    @Test
    public void solution() {
        int n = 9;
        System.out.println("res = " + reorderedPowerOf2(n));
    }


    public boolean reorderedPowerOf2(int n) {
        String str = fun(n);
        for (int i = 0; i <= 1000000000; i <<= 1) {
            if(str.equals(fun(i))) {
                return true;
            }
        }
        return false;
    }

    private String fun(int x) {
        char[] cnt = new char[10];
        for (; x > 0; x /= 10) {
            cnt[x % 10]++;
        }
        return new String(cnt);
    }

}

