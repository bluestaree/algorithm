package com.leetcode._2025_4;

import org.junit.Test;

import java.util.HashMap;


/**
 * 1399. 统计最大组的数目
 *
 * @author DHW
 * @date 2025/4/23 8: 32
 * @Version 1.0
*/
public class ProblemsNo1399 {

    @Test
    public void solution() {
        int n = 13;
        System.out.println("res = " + countLargestGroup(13));
    }

    public int countLargestGroup(int n) {
        int[] cnt = new int[40];
        int maxNum = 0;
        int res = 0;
        for (int i = 1; i <= n; ++i) {
            int s = 0;
            for (int x = i; x > 0; x /= 10) {
                s += x % 10;
            }
            ++cnt[s];
            if(maxNum < cnt[s]) {
                maxNum = cnt[s];
                res = 1;
            } else if(maxNum == cnt[s]) {
                ++res;
            }
        }
        return res;
    }
}

