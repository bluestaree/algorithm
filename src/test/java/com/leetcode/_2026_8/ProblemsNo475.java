package com.leetcode._2026_8;

import org.junit.Test;

import java.util.Arrays;


/**
 * 475. 供暖器
 *
 * @author DHW
 * @date 2026/8/17 9: 24
 * @Version 1.0
 */
public class ProblemsNo475 {

    @Test
    public void solution() {
        int[] houses = new int[]{1,5};
        int[] heaters = new int[]{10};
        System.out.println("= res = " + findRadius(houses, heaters));
    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        Arrays.sort(houses);
        int l = 0;
        int r = Math.max(houses[houses.length -1], heaters[heaters.length - 1]);
        while(l <= r) {
            int m = l + (r - l) / 2;
            if (check(m,houses,heaters)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private boolean check(int len, int[] houses, int[] heaters) {
        int m = 0 , n = 0;
        while(m < houses.length && n < heaters.length) {
            int d = Math.abs(houses[m] - heaters[n]);
            if(d <= len) {
                m++;
            } else {
                n++;
            }
        }
        if(m == houses.length) {
            return true;
        }
        return false;
    }
}

