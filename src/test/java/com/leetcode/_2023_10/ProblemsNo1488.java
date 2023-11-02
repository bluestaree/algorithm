package com.leetcode._2023_10;

import org.junit.Test;

import java.util.*;


/**
 * 1488. 避免洪水泛滥
 *
 * @author DHW
 * @date 2023/10/13 9:16
 * @Version 1.0
*/
public class ProblemsNo1488 {

    @Test
    public void solution() {
        int[] rains = new int[]{1,2,0,1,2};
        System.out.println("res = " + avoidFlood(rains));
    }

    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        TreeSet<Integer> sunny = new TreeSet<>();
        Map<Integer, Integer> rainy = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int v = rains[i];
            if (v > 0) {
                if (rainy.containsKey(v)) {
                    Integer t = sunny.higher(rainy.get(v));
                    if (t == null) {
                        return new int[0];
                    }
                    ans[t] = v;
                    sunny.remove(t);
                }
                rainy.put(v, i);
            } else {
                sunny.add(i);
                ans[i] = 1;
            }
        }
        return ans;
    }
}

