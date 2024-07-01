package com.leetcode._2024_6;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


/**
 * LCP 61. 气温变化趋势
 *
 * @author DHW
 * @date 2024/6/21 9:43
 * @Version 1.0
*/
public class ProblemsNoLCP61 {

    @Test
    public void solution() {
        int[] temperatureA = new int[]{21,18,18,18,31};
        int[] temperatureB = new int[]{34,32,16,16,17};
        System.out.println("res = " + temperatureTrend(temperatureA, temperatureB));
    }

    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int ans = 0;
        int same = 0;
        for (int i = 1; i < temperatureA.length; i++) {
            if (Integer.compare(temperatureA[i - 1], temperatureA[i]) == Integer.compare(temperatureB[i - 1], temperatureB[i])) {
                ans = Math.max(ans, ++same);
            } else {
                same = 0;
            }
        }
        return ans;
    }
}

