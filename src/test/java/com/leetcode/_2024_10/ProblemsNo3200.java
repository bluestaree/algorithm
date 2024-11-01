package com.leetcode._2024_10;

import org.junit.Test;

import java.util.HashSet;


/**
 * 3200. 三角形的最大高度
 *
 * @author DHW
 * @date 2024/10/15 9:53
 * @Version 1.0
*/
public class ProblemsNo3200 {

    @Test
    public void solution() {
        int red = 2;
        int blue = 3;
        System.out.println("res = " + maxHeightOfTriangle(red, blue));
    }

    public int maxHeightOfTriangle(int red, int blue) {
        int[] cnt = new int[2];
        for (int i = 1; ; i++) {
            cnt[i % 2] += i;
            if ((cnt[0] > red || cnt[1] > blue) && (cnt[0] > blue || cnt[1] > red)) {
                return i - 1;
            }
        }
    }
}

