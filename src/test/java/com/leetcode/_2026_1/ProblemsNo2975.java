package com.leetcode._2026_1;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


/**
 * 2975. 移除栅栏得到的正方形田地的最大面积
 *
 * @author DHW
 * @date 2026/1/16 9: 05
 * @Version 1.0
*/
public class ProblemsNo2975 {

    @Test
    public void solution() {
        int[] hBars = new int[]{2};
        int[] vBars = new int[]{8,6,5,4};
        int n = 3;
        int m = 9;
        System.out.println("res = " + maximizeSquareArea(n, m, hBars, vBars));
    }


    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        if(m == n) {
            return (m - 1) * (n - 1);
        }
        int ans = 0;
        HashSet<Integer> hset = new HashSet<>();
        hset.add(m - 1);
        for (int i = 0; i < hFences.length; i++) {
            hset.add(hFences[i] - 1);
            hset.add(m - hFences[i]);
            for (int j = i + 1; j < hFences.length; j++) {
                hset.add(Math.abs(hFences[j] - hFences[i]));
            }
        }

        if (hset.contains(n - 1)) ans = Math.max(ans, n - 1);
        for (int i = 0; i < vFences.length; i++) {
            if (hset.contains(vFences[i] - 1)) ans = Math.max(ans, vFences[i] - 1);
            if (hset.contains(n - vFences[i])) ans = Math.max(ans, n - vFences[i]);
            for (int j = i + 1; j < vFences.length; j++) {
                int z = Math.abs(vFences[j] - vFences[i]);
                if (hset.contains(z)) ans = Math.max(ans, z);
            }
        }
        if (ans == 0) return -1;
        return (int)((long)ans * ans % 1000000007);
    }
}

