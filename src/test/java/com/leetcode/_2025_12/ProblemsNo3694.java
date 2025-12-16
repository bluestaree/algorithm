package com.leetcode._2025_12;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


/**
 * 3694. 删除子字符串后不同的终点
 *
 * @author DHW
 * @date 2025/12/10 10: 14
 * @Version 1.0
*/
public class ProblemsNo3694 {

    @Test
    public void solution() {
        String s = "RLRSLL";
        int k = 1;
        System.out.println("res = " + distinctPoints(s, k));
    }

    public int distinctPoints(String s, int k) {
        int[][] dirs = new int[128][1];
        dirs['R'] = new int[]{1, 0};
        dirs['L'] = new int[]{-1, 0};
        dirs['U'] = new int[]{0, 1};
        dirs['D'] = new int[]{0, -1};
        int n = s.length();

        Set<Long> set = new HashSet<Long>();
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            x += dirs[s.charAt(i)][0];
            y += dirs[s.charAt(i)][1];

            int l = i - k + 1;
            if(l < 0) {
                continue;
            }
            set.add((long) (x + n) << 20 | (y + n));

            x -= dirs[s.charAt(l)][0];
            y -= dirs[s.charAt(l)][1];

        }
        return set.size();
    }
}

