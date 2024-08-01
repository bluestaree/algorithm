package com.leetcode._2024_7;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3096. 得到更多分数的最少关卡数目
 *
 * @author DHW
 * @date 2024/7/19 9:31
 * @Version 1.0
*/
public class ProblemsNo3096 {

    @Test
    public void solution() {
        int[] possible = new int[]{4,8,2,8};
        System.out.println("res = " + minimumLevels(possible));
    }

    public int minimumLevels(int[] possible) {
        int s = 0;
        for (int num : possible) {
            s += num == 0 ? -1 : 1;
        }
        int t = 0;
        for (int i = 1; i < possible.length; i++) {
            t += possible[i-1] == 0 ? -1 : 1;
            if(t > s - t) {
                return i;
            }
        }
        return -1;
    }
}

