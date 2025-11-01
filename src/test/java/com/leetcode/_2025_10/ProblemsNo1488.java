package com.leetcode._2025_10;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;


/**
 * 1488. 避免洪水泛滥
 *
 * @author DHW
 * @date 2025/10/7 10: 25
 * @Version 1.0
*/
public class ProblemsNo1488 {

    @Test
    public void solution() {
        int[] rains =  new int[]{4,2,5};
        System.out.println("res = " + avoidFlood(rains));
    }

    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        TreeSet<Integer> set = new TreeSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int v = rains[i];
            if (v > 0) {
                if (map.containsKey(v)) {
                    Integer higher = set.higher(map.get(v));
                    if (higher == null) {
                        return new int[]{};
                    }
                    ans[i] = higher;
                    map.remove(higher);
                }
                map.put(v, i);
            } else {
                set.add(i);
                ans[i] = 1;
            }
        }
        return ans;
    }
}

