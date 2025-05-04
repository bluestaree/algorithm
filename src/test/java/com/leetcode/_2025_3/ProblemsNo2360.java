package com.leetcode._2025_3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * 2360. 图中的最长环
 *
 * @author DHW
 * @date 2025/3/29 10: 46
 * @Version 1.0
*/
public class ProblemsNo2360 {

    @Test
    public void solution() {
        int[] edges = new int[]{3,3,4,2,3};
        System.out.println("res = " + longestCycle(edges));
    }

    public int longestCycle(int[] edges) {
        int res = -1;
        int n = edges.length;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (vis[i]) {
                continue;
            }
            int j = i;
            ArrayList<Integer> list = new ArrayList<>();
            for (; j != -1 && !vis[j]; j = edges[j]) {
                vis[j] = true;
                list.add(j);
            }
            if (j == -1) {
                continue;
            }
            for (int k = 0; k < list.size(); k++) {
                if (list.get(k) == j) {
                    res = Math.max(res, list.size() - k);
                    break;
                }
            }
        }
        return res;
    }
}

