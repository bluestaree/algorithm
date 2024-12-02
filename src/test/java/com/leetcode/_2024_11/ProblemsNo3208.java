package com.leetcode._2024_11;

import org.junit.Test;


/**
 * 3208. 交替组 II
 *
 * @author DHW
 * @date 2024/11/27 8: 45
 * @Version 1.0
 */
public class ProblemsNo3208 {

    @Test
    public void solution() {
        int[] colors = new int[]{0,1,0,0,1,0,1};
        System.out.println("res = " + numberOfAlternatingGroups(colors, 6));
    }

    public int numberOfAlternatingGroups(int[] colors, int k) {
        int res = 0;
        int n = colors.length;
        boolean preCheck = false;
        int num = k % 2;
        for (int i = 0, j = k - 1; i < n; i++, j++) {
            if(num == 1 ? colors[i] == colors[j % n] : colors[i] != colors[j % n]) {
                if (preCheck) {
                    res++;
                    continue;
                }
                if(checkGroups(i+1, j, n, colors)) {
                    preCheck = true;
                    res++;
                    continue;
                }
            }
            preCheck = false;
        }
        return res;
    }

    private boolean checkGroups(int l, int r, int n, int[] colors) {
        for (; l <= r; l++) {
            if(colors[l % n] == colors[(l-1) % n]) {
                return false;
            }
        }
        return true;
    }
}

