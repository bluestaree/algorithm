package com.leetcode._2024_10;

import org.junit.Test;


/**
 * 3184. 构成整天的下标对数目 I
 *
 * @author DHW
 * @date 2024/10/22 9:34
 * @Version 1.0
*/
public class ProblemsNo3184 {

    @Test
    public void solution() {
        int[] hours = new int[]{4,8,2,8};
        System.out.println("res = " + countCompleteDayPairs(hours));
    }

    public int countCompleteDayPairs(int[] hours) {
        int[] cnt = new int[24];
        int res = 0;
        for (int x : hours) {
            res += cnt[(24 - x % 24) % 24];
            ++cnt[x % 24];
        }
        return res;
    }
}

