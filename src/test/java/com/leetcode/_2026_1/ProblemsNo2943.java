package com.leetcode._2026_1;

import org.junit.Test;

import java.util.Arrays;


/**
 * 2943. 最大化网格图中正方形空洞的面积
 *
 * @author DHW
 * @date 2026/1/15 9: 17
 * @Version 1.0
*/
public class ProblemsNo2943 {

    @Test
    public void solution() {
        int[] hBars = new int[]{2,3};
        int[] vBars = new int[]{2};
        int n = 1;
        int m = 1;
        System.out.println("res = " + maximizeSquareHoleArea(n, m, hBars, vBars));
    }

    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int a = 1;
        int b = 1;
        int cnt = 1;
        for (int i = 1; i < hBars.length; i++) {
            if (hBars[i] == hBars[i - 1] + 1) {
                cnt++;
                a = Math.max(a, cnt);
            } else {
                cnt = 1;
            }
        }
        cnt = 1;
        for (int i = 1; i < vBars.length; i++) {
            if (vBars[i] == vBars[i - 1] + 1) {
                cnt++;
                b = Math.max(b, cnt);
            } else {
                cnt = 1;
            }
        }
        int ans = Math.min(a, b) + 1;
        return ans * ans;
    }
}

