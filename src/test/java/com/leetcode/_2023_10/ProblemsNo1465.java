package com.leetcode._2023_10;

import org.junit.Test;

import java.util.Arrays;


/**
 * 1465. 切割后面积最大的蛋糕
 *
 * @author DHW
 * @date 2023/10/27 8:55
 * @Version 1.0
*/
public class ProblemsNo1465 {

    @Test
    public void solution() {
        int h = 10;
        int w = 15;
        int[] horizontalCuts = new int[]{1,2,3,1};
        int[] verticalCuts = new int[]{1,2,3,1};
        System.out.println("res = " + maxArea(h, w, horizontalCuts, verticalCuts));
    }

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int hlen = horizontalCuts.length;
        int vlen = verticalCuts.length;
        long x = Math.max(horizontalCuts[0], h - horizontalCuts[hlen-1]);
        long y = Math.max(verticalCuts[0], w - verticalCuts[vlen-1]);
        for (int i = 1; i < hlen; i++) {
            x = Math.max(x, horizontalCuts[i] - horizontalCuts[i-1]);
        }
        for (int i = 1; i < vlen; i++) {
            y = Math.max(y, verticalCuts[i] - verticalCuts[i-1]);
        }
        return (int) (x * y % 1000000007);
    }
}

